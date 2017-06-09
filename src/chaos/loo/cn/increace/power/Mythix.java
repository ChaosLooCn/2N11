package chaos.loo.cn.increace.power;

import java.util.Random;

public class Mythix {

    static int points;
    int grid[][] = new int[4][4];
    int position = 0;
    int twoorfour = -1;
    int voidnumber = 0;
    int report[] = new int[16];
    int mergable[] = new int[16];
    int intvalue[] = new int[16];

    public void setGrid(int[] intvalue) {
        for (int i = 0; i < 16; i++) {
            this.intvalue[i] = intvalue[i];
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                grid[i][j] = this.intvalue[4 * i + j];

        }
    }

    public int[] report() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                report[4 * i + j] = grid[i][j];
        }
        return report;
    }

    public int generate(int model) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                if (grid[i][j] == 0) {
                    voidnumber++;
                }
        }

        if (voidnumber > 0) {
            Random random = new Random();
            position = (int) (random.nextInt(voidnumber) + 1);
            voidnumber = 0;
            for (int m = 0; m < 4; m++) {
                for (int n = 0; n < 4; n++) {
                    if (grid[m][n] == 0) {
                        if (position == 1) {

                            Random random2 = new Random();
                            twoorfour = (int) (random2.nextInt(7));
                            if ((twoorfour == 4) & (model == 0)) {
                                grid[m][n] = 2;
                                return (4 * m + n + 1000);

                            } else if ((twoorfour != 4) & (model == 0)) {
                                grid[m][n] = 1;
                                return (4 * m + n);
                            } else if (model == 1) {
                                grid[m][n] = 1;
                                return (4 * m + n);
                            }
                        } else{
                            
                            position--;
                        }
                    }
                }
            }
        } else
            position = -5;

        if (position == -5)
            return -2;
        else
            return -1;

    }

    public void merge(int slidDirect) {
        switch (slidDirect) {
            case 1: {
                for (int j = 0; j < 4; j++) {
                    if (grid[0][j] != 0) {
                        if (grid[1][j] != 0) {
                            if (grid[0][j] == grid[1][j]) {
                                grid[0][j]++;
                                points += Math.pow(2, (grid[0][j] + 0.5));
                                grid[1][j] = 0;
                                if (grid[2][j] != 0) {
                                    if (grid[3][j] != 0) {
                                        if (grid[2][j] == grid[3][j]) {
                                            grid[2][j]++;
                                            points += Math.pow(2, (grid[2][j] + 0.5));
                                            grid[3][j] = 0;
                                        }
                                    }
                                }
                            }

                            else {
                                if (grid[2][j] != 0) {
                                    if (grid[1][j] == grid[2][j]) {
                                        grid[1][j]++;
                                        points += Math.pow(2, (grid[1][j] + 0.5));
                                        grid[2][j] = 0;
                                    } else {
                                        if (grid[3][j] != 0) {
                                            if (grid[2][j] == grid[3][j]) {
                                                grid[2][j]++;
                                                points += Math.pow(2, (grid[2][j] + 0.5));
                                                grid[3][j] = 0;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int j = 0; j < 4; j++) {
                    if (grid[3][j] != 0) {
                        if (grid[2][j] != 0) {
                            if (grid[3][j] == grid[2][j]) {
                                grid[3][j]++;
                                points += Math.pow(2, (grid[3][j] + 0.5));
                                grid[2][j] = 0;
                                if (grid[1][j] != 0) {
                                    if (grid[0][j] != 0) {
                                        if (grid[1][j] == grid[0][j]) {
                                            grid[1][j]++;
                                            points += Math.pow(2, (grid[1][j] + 0.5));
                                            grid[0][j] = 0;
                                        }
                                    }
                                }
                            }

                            else {
                                if (grid[1][j] != 0) {
                                    if (grid[2][j] == grid[1][j]) {
                                        grid[2][j]++;
                                        points += Math.pow(2, (grid[2][j] + 0.5));
                                        grid[1][j] = 0;
                                    } else {
                                        if (grid[0][j] != 0) {
                                            if (grid[1][j] == grid[0][j]) {
                                                grid[1][j]++;
                                                points += Math.pow(2, (grid[1][j] + 0.5));
                                                grid[0][j] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                break;
            }
            case 3: {
                for (int i = 0; i < 4; i++) {
                    if (grid[i][0] != 0) {
                        if (grid[i][1] != 0) {
                            if (grid[i][0] == grid[i][1]) {
                                grid[i][0]++;
                                points += Math.pow(2, (grid[i][0] + 0.5));
                                grid[i][1] = 0;
                                if (grid[i][2] != 0) {
                                    if (grid[i][3] != 0) {
                                        if (grid[i][2] == grid[i][3]) {
                                            grid[i][2]++;
                                            points += Math.pow(2, (grid[i][2] + 0.5));
                                            grid[i][3] = 0;
                                        }
                                    }
                                }
                            }

                            else {
                                if (grid[i][2] != 0) {
                                    if (grid[i][1] == grid[i][2]) {
                                        grid[i][1]++;
                                        points += Math.pow(2, (grid[i][1] + 0.5));
                                        grid[i][2] = 0;
                                    } else {
                                        if (grid[i][3] != 0) {
                                            if (grid[i][2] == grid[i][3]) {
                                                grid[i][2]++;
                                                points += Math.pow(2, (grid[i][2] + 0.5));
                                                grid[i][3] = 0;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

                break;
            }
            case 4: {
                for (int i = 0; i < 4; i++) {
                    if (grid[i][3] != 0) {
                        if (grid[i][2] != 0) {
                            if (grid[i][3] == grid[i][2]) {
                                grid[i][3]++;
                                points += Math.pow(2, (grid[i][3] + 0.5));
                                grid[i][2] = 0;
                                if (grid[i][1] != 0) {
                                    if (grid[i][0] != 0) {
                                        if (grid[i][1] == grid[i][0]) {
                                            grid[i][1]++;
                                            points += Math.pow(2, (grid[i][1] + 0.5));
                                            grid[i][0] = 0;
                                        } else
                                            ;
                                    } else
                                        ;
                                } else
                                    ;
                            }

                            else {
                                if (grid[i][1] != 0) {
                                    if (grid[i][2] == grid[i][1]) {
                                        grid[i][2]++;
                                        points += Math.pow(2, (grid[i][2] + 0.5));
                                        grid[i][1] = 0;
                                    } else {
                                        if (grid[i][0] != 0) {
                                            if (grid[i][1] == grid[i][0]) {
                                                grid[i][1]++;
                                                points += Math.pow(2, (grid[i][1] + 0.5));
                                                grid[i][0] = 0;
                                            } else
                                                ;
                                        } else
                                            ;
                                    }

                                } else
                                    ;
                            }
                        } else
                            ;
                    } else
                        ;
                }

                break;
            }
        }
    }

    public void slide(int slidDirect) {
        switch (slidDirect) {
            case 1: {
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 4; i++) {
                        int k = 0;
                        while ((grid[i][j] == 0) & (k < 3)) {
                            for (int l = i; l < 3; l++) {
                                grid[l][j] = grid[l + 1][j];
                            }
                            grid[3][j] = 0;
                            k++;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int j = 0; j < 4; j++) {
                    for (int i = 3; i > 0; i--) {
                        int k = 0;
                        while ((grid[i][j] == 0) & (k < 3)) {
                            for (int l = i; l > 0; l--) {
                                grid[l][j] = grid[l - 1][j];
                            }
                            grid[0][j] = 0;
                            k++;
                        }
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        int k = 0;
                        while ((grid[i][j] == 0) & (k < 3)) {
                            for (int l = j; l < 3; l++) {
                                grid[i][l] = grid[i][l + 1];
                            }
                            grid[i][3] = 0;
                            k++;
                        }
                    }
                }
                break;
            }
            case 4: {
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j > 0; j--) {
                        int k = 0;
                        while ((grid[i][j] == 0) & (k < 3)) {
                            for (int l = j; l > 0; l--) {
                                grid[i][l] = grid[i][l - 1];
                            }
                            grid[i][0] = 0;
                            k++;
                        }
                    }
                }
                break;
            }
        }

    }

    public void resetPoints() {

        points = 0;
    }

    public int checkZeroNumber() {
        int zeroNumber = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0)
                    zeroNumber++;
                else
                    ;
            }
        }
        return zeroNumber;
    }

    public int checkMergable() {

        int sameJudgement = 1;
        int pointscopy = points;
        Mythix mergable = new Mythix();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mergable.grid[i][j] = grid[i][j];
            }
        }

        mergable.merge(1);
        mergable.merge(2);
        mergable.merge(3);
        mergable.merge(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mergable.grid[i][j] == grid[i][j])
                    ;
                else
                    sameJudgement = 0;
            }
        }
        points = pointscopy;

        Process pro = new Process();
        if (sameJudgement == 0) {
            pro.fileSortable = 1;
            pro.scoreEnable = 1;
        } else
            pro.judge = 1;
        return sameJudgement;
    }
}