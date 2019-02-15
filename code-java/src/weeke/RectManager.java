package weeke;

import java.util.Scanner;

class Rect{
	int left; //x1
	int top;  //y1
	int right; //x2
	int bottom;	 //y2
}
public class RectManager {
	float area;//Recode area
	int nFlag; //recode the relation of two rectangle
	
	public static void main(String[] args) {
		Rect A=new Rect();
		Rect B=new Rect();

		while(true){
			System.out.print("Input rectangle A（Format:left top right bottom）：");
			Scanner scan = new Scanner(System.in);
			A.left = scan.nextInt();
			A.top = scan.nextInt();
			A.right = scan.nextInt();
			A.bottom = scan.nextInt();

			System.out.print("Input rectangle B（Format:left top right bottom）：");
			B.left = scan.nextInt();
			B.top = scan.nextInt();
			B.right = scan.nextInt();
			B.bottom = scan.nextInt();

			//Check the input
			if (!(A.left>=0 && A.right<640)|| !(A.top>=0 && A.bottom<960)
					||!(A.right>=A.left) || !(A.bottom>=A.top)){
				System.out.println("Input error in Rectangle A");
				return;
			}
			if (!(B.left>=0 && B.right<640)|| !(B.top>=0 && B.bottom<960)
					||!(B.right>=B.left) || !(B.bottom>=B.top)){
				System.out.println("Input error in Rectangle B");
				return;
			}

			RectManager test= new RectManager();
			test.solve(A, B);

			if (test.nFlag==0){
				System.out.println("矩形不相交！");
				return;
			}else if (test.nFlag==1){
				System.out.println("矩形相交于一个区域！");
			}else if (test.nFlag==2){
				System.out.println("矩形相交于一个区域且为包含关系！");
			}else if (test.nFlag==3){
				System.out.println("矩形相交于一个区域且正好重合！");
			}else if (test.nFlag==4){
				System.out.println("矩形相交于一个区域且交点为1个点！");
			}else if (test.nFlag==5){
				System.out.println("矩形相交于一个区域且交点为1条线段！");
			}
			System.out.println("相交面积："+test.area);
		}

	}
	
public void solve(Rect A, Rect B){
    int nMaxLeft = 0;
    int nMaxTop = 0;
    int nMinRight = 0;
    int nMinBottom = 0;
    if (A.left >= B.left) {
        nMaxLeft = A.left;
    }
    else {
        nMaxLeft = B.left;
    }
    if (A.top >= B.top) {
        nMaxTop = A.top;
    }
    else {
        nMaxTop = B.top;
    }
    if (A.right <= B.right) {
        nMinRight = A.right;
    }
    else {
        nMinRight = B.right;
    }
    if (A.bottom <= B.bottom) {
        nMinBottom = A.bottom;
    }
    else {
        nMinBottom = B.bottom;
    }
    if ((nMaxLeft > nMinRight) ||
        (nMaxTop > nMinBottom)) {
        nFlag=0;
    }
    else {
        nFlag = 1;
        area = (nMinRight - nMaxLeft   + 1 ) * (nMinBottom - nMaxTop + 1);
        if ((B.left==A.left) &&
            (B.right==A.right) &&
            (B.top==A.top) &&
            (B.bottom==A.bottom)){
            nFlag = 3;
        }
        else if (((nMaxLeft==A.left)
                && (nMinRight==A.right)
                && (nMaxTop==A.top)
                && (nMinBottom==A.bottom))
         ||((nMaxLeft==B.left)
                && (nMinRight==B.right)
                && (nMaxTop==B.top)
                && (nMinBottom==B.bottom))){
            nFlag = 2;
        }
        else if ((nMaxLeft==nMinRight)
                && (nMaxTop == nMinBottom)){
            nFlag = 4;
        }
        else if (((nMaxLeft==nMinRight)
                && (nMaxTop < nMinBottom))
              || ((nMaxLeft<nMinRight)
                && (nMaxTop == nMinBottom))){
            nFlag = 5;
        }
    }
}
	
}
