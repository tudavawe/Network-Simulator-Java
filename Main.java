import EncodeHelper.ErrorDetection;
import EncodeHelper.ErrorCorrection;
import MessageHelper.Message;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(ErrorCorrection.parityBlockVerify(new Message("0001101001111010"),3));
    }
}
