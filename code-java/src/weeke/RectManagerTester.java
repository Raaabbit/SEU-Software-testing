package weeke;
import java.util.Random;
public class RectManagerTester{
    /*
    对RectManager进行随机测试，实现目标：
        随机成城测试用例
        对6种相交情况进行统计，同时记录不合法输入情况
     */
    public static void main(String[] args){
        // 实例化两个四边形
        Rect testA = new Rect();
        Rect testB = new Rect();
        // 6中相交情况的数量记录
        int case0Num = 0, case1Num = 0, case2Num = 0,
                case3Num = 0, case4Num = 0, case5Num = 0;
        // 随机测试中非法用例的数量
        int errorInputNum = 0;
        // 实例化一个测试者
        RectManager manager = new RectManager();
        int usecaseNum = 100000;
        for (int i = 0; i < usecaseNum; i++) {
            // 随机生成参数
            testA.left = new Random().nextInt(660)-10;
            testA.right = new Random().nextInt(660)-10;
            testA.top = new Random().nextInt(980)-10;
            testA.bottom = new Random().nextInt(980)-10;

            testB.left = new Random().nextInt(660)-10;
            testB.right = new Random().nextInt(660)-10;
            testB.top = new Random().nextInt(980)-10;
            testB.bottom = new Random().nextInt(980)-10;

            //检查异常输入
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
            // 统计随机测试结果
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
        System.out.print("测试用例共: "+usecaseNum+" 个\n"
            +"矩形不相交: "+case0Num+" 个\n"
            +"矩形相交于一个区域: "+case1Num+" 个\n"
            +"矩形相交于一个区域且为包含关系: "+case2Num+" 个\n"
            +"矩形相交于一个区域且正好重合: "+case3Num+" 个\n"
            +"矩形相交于一个区域且交点为1个点: "+case4Num+" 个\n"
            +"矩形相交于一个区域且交点为一条线段: "+case5Num+" 个\n"
            +"非法用例: "+errorInputNum+" 个\n"
        );
    }
}