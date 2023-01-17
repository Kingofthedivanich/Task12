public class Solution {
    public static int counter = 0;
    public static char[][] charTwist(char[][] input){
        char[][] output = new char[input.length][];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[input.length - 1 - i];
        }
        return output;
    }
    public static double widthCheck(char[] arg){
        double width = 1;


        for (int i = 0; i < arg.length; i++){
            if (arg[i] == 89){
                width = width + Math.pow(2 ,(arg.length - i));
            }
        }
        return width;
    }
    public static double highCheck(char[] arg){
        double h = 0;
        for (int i = 1; i <= arg.length; i++){
            h = h + Math.pow(2, i);
        }
        return h;
    }
    public static double highElement(int arg){
        double h;
        h = Math.pow(2, arg);
        return h;
    }
    public static char[][] PictureBuilder(char[] ch, char[][] picture){

        if(counter == 0) {
            int dots = 1;
            if (ch[counter] == 89){
                for (int i = 0; i < highElement(ch.length - counter); i++) {
                    if (i < (highElement(ch.length - counter) / 2)) {
                        for (int j = 0; j < widthCheck(ch); j++){
                            if(j == (((widthCheck(ch) - 1) / 2))){
                                picture[i][j] = 124;
                            }
                            else {
                                picture[i][j] = 46;
                            }
                        }
                    }
                    else{
                        for (int j = 0; j < widthCheck(ch); j++){
                            if(j == (((widthCheck(ch) - 1) / 2)) - dots){
                                picture[i][j] = 92;
                            } else if (j == (((widthCheck(ch) - 1) / 2)) + dots) {
                                picture[i][j] = 47;
                            } else {
                                picture[i][j] = 46;
                            }
                        }
                        dots = dots + 1;
                    }
                }
            }
            else {
                for (int i = 0; i < highElement(ch.length - counter); i++){
                    for (int j = 0; j < widthCheck(ch); j++){
                        if(j == (((widthCheck(ch) - 1) / 2))){
                            picture[i][j] = 124;
                        }
                        else {
                            picture[i][j] = 46;
                        }
                    }
                }
            }
            counter = counter + 1;

            PictureBuilder(ch, picture);
        }
        else if(counter < ch.length) {
            double high = 0;
            for(int i = 0; i < counter; i++){
                high = high + highElement(ch.length - i);
            }

            if (ch[counter] == 89){
                for(int i = (int) high; i < high + highElement(ch.length - counter); i++){
                    if(i < high + highElement(ch.length - counter) / 2){
                        for (int j = 0; j < widthCheck(ch); j++){
                            if(picture[i - 1][j] == 46){
                                picture[i][j] = 46;
                            }
                            else {
                                picture[i][j] = 124;
                            }
                        }
                    }
                    else {
                        for (int j = 0; j < widthCheck(ch); j++){
                            if((picture[i - 1][j] == 124)){
                                picture[i][j] = 46;
                                picture[i][j - 1] = 92;
                                picture[i][j + 1] = 47;
                                j++;
                            }
                            else if ((picture[i - 1][j] == 92)) {
                                picture[i][j-1] = 92;
                                picture[i][j] = 46;
                            }
                            else if (picture[i - 1][j] == 47) {
                                picture[i][j + 1] = 47;
                                picture[i][j] = 46;
                                j++;
                            }
                            else {
                                picture[i][j] = 46;
                            }
                        }
                    }
                }
            }
            else {
                for(int i = (int) high; i < high + highElement(ch.length - counter); i++){
                    for (int j = 0; j < widthCheck(ch); j++){
                        if(picture[i - 1][j] == 46){
                            picture[i][j] = 46;
                        }
                        else {
                            picture[i][j] = 124;
                        }
                    }
                }
            }
            counter = counter + 1;
            PictureBuilder(ch, picture);
        }

        return picture;
    }
    public static void solution(char[] strToArray) {
        char[][] picture = new char[(int) highCheck(strToArray)][(int) widthCheck(strToArray)];
        char[][] result = charTwist(PictureBuilder(strToArray, picture));
        for (int i = 0; i < picture.length; i++){
            System.out.println(result[i]);
        }
    }
}
