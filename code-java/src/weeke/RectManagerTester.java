package weeke;
import java.util.Random;
public class RectManagerTester{
    /*
    ��RectManager����������ԣ�ʵ��Ŀ�꣺
        ����ɳǲ�������
        ��6���ཻ�������ͳ�ƣ�ͬʱ��¼���Ϸ��������
     */
    public static void main(String[] args){
        // ʵ���������ı���
        Rect testA = new Rect();
        Rect testB = new Rect();
        // 6���ཻ�����������¼
        int case0Num = 0, case1Num = 0, case2Num = 0,
                case3Num = 0, case4Num = 0, case5Num = 0;
        // ��������зǷ�����������
        int errorInputNum = 0;
        // ʵ����һ��������
        RectManager manager = new RectManager();
        int usecaseNum = 100000;
        for (int i = 0; i < usecaseNum; i++) {
            // ������ɲ���
            testA.left = new Random().nextInt(660)-10;
            testA.right = new Random().nextInt(660)-10;
            testA.top = new Random().nextInt(980)-10;
            testA.bottom = new Random().nextInt(980)-10;

            testB.left = new Random().nextInt(660)-10;
            testB.right = new Random().nextInt(660)-10;
            testB.top = new Random().nextInt(980)-10;
            testB.bottom = new Random().nextInt(980)-10;

            //����쳣����
            if (!(testA.left>=0 && testA.right<640)|| !(testA.top>=0 && testA.bottom<960)
                    ||!(testA.right>=testA.left) || !(testA.bottom>=testA.top)){
                errorInputNum++;
            }else if (!(testB.left>=0 && testB.right<640)|| !(testB.top>=0 && testB.bottom<960)
                    ||!(testB.right>=testB.left) || !(testB.bottom>=testB.top)){
               errorInputNum++;
            }else if (testA.left<0||testA.right>639||testA.top<0||testA.bottom>950
            ||testB.left<0||testB.right>639||testB.top<0||testB.bottom>950){
                errorInputNum++;
            }
            // ͳ��������Խ��
            manager.solve(testA,testB);
            switch (manager.nFlag){
                case 0:
                    case0Num++;
                    break;
                case 1:
                    case1Num++;
                    break;
                case 2:
                    case2Num++;
                    break;
                case 3:
                    case3Num++;
                    break;
                case 4:
                    case4Num++;
                    break;
                case 5:
                    case5Num++;
                    break;
            }
        }
        System.out.print("����������: "+usecaseNum+" ��\n"
            +"���β��ཻ: "+case0Num+" ��\n"
            +"�����ཻ��һ������: "+case1Num+" ��\n"
            +"�����ཻ��һ��������Ϊ������ϵ: "+case2Num+" ��\n"
            +"�����ཻ��һ�������������غ�: "+case3Num+" ��\n"
            +"�����ཻ��һ�������ҽ���Ϊ1����: "+case4Num+" ��\n"
            +"�����ཻ��һ�������ҽ���Ϊһ���߶�: "+case5Num+" ��\n"
            +"�Ƿ�����: "+errorInputNum+" ��\n"
        );
    }
}