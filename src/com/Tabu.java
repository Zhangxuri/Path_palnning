package com;

import java.io.*;
import java.util.Random;

/**
 * 单线程实现禁忌搜索算法解决TSP问题
 *
 *
 * @author wucl(lailaiwcl@163.com)
 *
 */
public class Tabu {

    private int MAX_GEN;// 迭代次数

    private int N;// 每次搜索邻居个数

    private int ll;// 禁忌长度

    private int cityNum; // 城市数量，编码长度

    private double[][] distance; // 距离矩阵

    private int bestT;// 最佳出现代数

    private int[] Ghh;// 初始路径编码

    private int[] bestGh;// 最好的路径编码

    private double bestEvaluation;

    private int[] LocalGhh;// 当代最好编码

    private double localEvaluation;

    private int[] tempGhh;// 存放临时编码

    private double tempEvaluation;

    private int[][] jinji;// 禁忌表

    private int t;// 当前代数

    private Random random;

    public Tabu() {

    }

    /**
     *
     * constructor of Tabu
     *
     * @param n
     *
     *            城市数量
     * @param g
     *
     *            运行代数
     * @param c
     *
     *            每次搜索邻居个数
     *
     * @param m
     *
     *            禁忌长度
     *
     **/

    public Tabu(int n, int g, int c, int m) {
        cityNum = n;
        MAX_GEN = g;
        N = c;
        ll = m;
    }


    private void init() throws IOException {

        // 读取数据
        double[] x;
        double[] y;
        String strbuff;
        Reader reader = new InputStreamReader(Tabu.class.getClassLoader().getResourceAsStream("a/data.txt"));
        BufferedReader data = new BufferedReader(reader);
        distance = new double[cityNum][cityNum];
        x = new double[cityNum];
        y = new double[cityNum];
        for (int i = 0; i < cityNum; i++) {
            strbuff = data.readLine();
            String[] strcol = strbuff.split(" ");
            x[i] = Double.valueOf(strcol[1]);// x坐标
            y[i] = Double.valueOf(strcol[2]);// y坐标

        }
        // 计算距离矩阵
        //System.out.println("距离矩阵为：");
        for (int i = 0; i < cityNum - 1; i++) {
            distance[i][i] = 0; // 对角线为0
            for (int j = 0; j < cityNum; j++) {
                distance[i][j] = Math
                        .sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
                                * (y[i] - y[j])));
                //System.out.print(Math.ceil(distance[i][j]) + " ");
            }
            //System.out.println();

        }

        distance[cityNum - 1][cityNum - 1] = 0;
        Ghh = new int[cityNum];
        bestGh = new int[cityNum];
        bestEvaluation = Integer.MAX_VALUE;
        LocalGhh = new int[cityNum];
        localEvaluation = Integer.MAX_VALUE;
        tempGhh = new int[cityNum];
        tempEvaluation = Integer.MAX_VALUE;
        jinji = new int[ll][cityNum];
        bestT = 0;
        t = 0;
        random = new Random(System.currentTimeMillis());
    }
    public void init(String inputData) throws IOException {

        ByteArrayInputStream is=new ByteArrayInputStream(inputData.getBytes());
        BufferedReader data=new BufferedReader(new InputStreamReader(is));
        // 读取数据
        double[] x;
        double[] y;
        String strbuff;
        distance = new double[cityNum][cityNum];
        x = new double[cityNum];
        y = new double[cityNum];
        for (int i = 0; i < cityNum; i++) {
            strbuff = data.readLine();
            String[] strcol = strbuff.split(" ");
            x[i] = Double.valueOf(strcol[1]);// x坐标
            y[i] = Double.valueOf(strcol[2]);// y坐标

        }
        // 计算距离矩阵
        //System.out.println("距离矩阵为：");
        for (int i = 0; i < cityNum - 1; i++) {
            distance[i][i] = 0; // 对角线为0
            for (int j = 0; j < cityNum; j++) {
                distance[i][j] = Math
                        .sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
                                * (y[i] - y[j])));
                //System.out.print(Math.ceil(distance[i][j]) + " ");
            }
            //System.out.println();

        }

        distance[cityNum - 1][cityNum - 1] = 0;
        Ghh = new int[cityNum];
        bestGh = new int[cityNum];
        bestEvaluation = Integer.MAX_VALUE;
        LocalGhh = new int[cityNum];
        localEvaluation = Integer.MAX_VALUE;
        tempGhh = new int[cityNum];
        tempEvaluation = Integer.MAX_VALUE;
        jinji = new int[ll][cityNum];
        bestT = 0;
        t = 0;
        random = new Random(System.currentTimeMillis());
    }

    // 初始化编码Ghh

    void initGroup() {
        int i, j;
        Ghh[0] = random.nextInt(65535) % cityNum;
        for (i = 1; i < cityNum;)// 编码长度
        {
            Ghh[i] = random.nextInt(65535) % cityNum;
            for (j = 0; j < i; j++) {
                if (Ghh[i] == Ghh[j]) {
                    break;
                }
            }
            if (j == i) {
                i++;
            }
        }
    }

    // 复制编码体，复制编码Gha到Ghb

    public void copyGh(int[] Gha, int[] Ghb) {
        for (int i = 0; i < cityNum; i++) {
            Ghb[i] = Gha[i];
        }
    }

    public double evaluate(int[] chr) {
        double len = 0;
        // 编码，起始城市,城市1,城市2...城市n
        for (int i = 1; i < cityNum; i++) {
            len += distance[chr[i - 1]][chr[i]];
        }
        // // 城市n,起始城市
        len += distance[chr[cityNum - 1]][chr[0]];
        // for (int i = 1; i < cityNum; i++) {
        // System.out.print(chr[i] + ",");
        // }
        // System.out.println("-------------" + len);
        return len;
    }

    // 邻域交换，得到邻居
    public void Linju(int[] Gh, int[] tempGh) {
        int i, temp;
        int ran1, ran2;
        for (i = 0; i < cityNum; i++) {
            tempGh[i] = Gh[i];
        }
        ran1 = random.nextInt(65535) % cityNum;
        ran2 = random.nextInt(65535) % cityNum;
        while (ran1 == ran2) {
            ran2 = random.nextInt(65535) % cityNum;
        }
        temp = tempGh[ran1];
        tempGh[ran1] = tempGh[ran2];
        tempGh[ran2] = temp;

    }

    // 判断编码是否在禁忌表中

    public int panduan(int[] tempGh) {
        int i, j;
        int flag = 0;
        for (i = 0; i < ll; i++) {
            flag = 0;
            for (j = 0; j < cityNum; j++) {
                if (tempGh[j] != jinji[i][j]) {
                    flag = 1;// 不相同
                    break;
                }
            }
            if (flag == 0)// 相同，返回存在相同
            {
                // return 1;
                break;

            }
        }

        if (i == ll)// 不等
        {
            return 0;// 不存在

        } else {
            return 1;// 存在
        }
    }

    // 解禁忌与加入禁忌

    public void jiejinji(int[] tempGh) {
        int i, j, k;
        // 删除禁忌表第一个编码，后面编码往前挪动
        for (i = 0; i < ll - 1; i++) {
            for (j = 0; j < cityNum; j++) {
                jinji[i][j] = jinji[i + 1][j];
            }
        }

        // 新的编码加入禁忌表

        for (k = 0; k < cityNum; k++) {
            jinji[ll - 1][k] = tempGh[k];
        }
    }

    public void solve() {
        int nn;
        // 初始化编码Ghh
        initGroup();
        copyGh(Ghh, bestGh);// 复制当前编码Ghh到最好编码bestGh
        bestEvaluation = evaluate(Ghh);
        while (t < MAX_GEN) {
            nn = 0;
            localEvaluation = Integer.MAX_VALUE;
            while (nn < N) {
                Linju(Ghh, tempGhh);// 得到当前编码Ghh的邻域编码tempGhh
                if (panduan(tempGhh) == 0)// 判断编码是否在禁忌表中
                {
                    // 不在
                    tempEvaluation = evaluate(tempGhh);
                    if (tempEvaluation < localEvaluation) {
                        copyGh(tempGhh, LocalGhh);
                        localEvaluation = tempEvaluation;
                    }
                    nn++;
                }
            }
            if (localEvaluation < bestEvaluation) {
                bestT = t;
                copyGh(LocalGhh, bestGh);
                bestEvaluation = localEvaluation;
            }
            copyGh(LocalGhh, Ghh);
            // 解禁忌表，LocalGhh加入禁忌表
            jiejinji(LocalGhh);
            t++;
        }
        System.out.print("最佳长度出现代数：");
        System.out.println(bestT);
        System.out.print("最佳长度：");
        System.out.println(bestEvaluation);
        System.out.print("最佳路径：");
        for (int i = 0; i < cityNum; i++) {
            System.out.print(bestGh[i] + "->");
        }
    }
    public int[] getBestGh(){
        return bestGh;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Start....");
        Tabu tabu = new Tabu(6,10000, 200, 20);
        tabu.init("m 116.169473 39.72735\n" +
                "v 116.481706 39.875344\n" +
                "n 116.31088 39.99281\n" +
                "k 116.30621 39.976121\n" +
                "p 116.321337 39.894966\n" +
                "u 116.397573 39.908743");
        long t1 = System.currentTimeMillis();
        tabu.solve();
        System.out.println();
        System.out.println("计算用时：" + (System.currentTimeMillis() - t1));
    }

}
