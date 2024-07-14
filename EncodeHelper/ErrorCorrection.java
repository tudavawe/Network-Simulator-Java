package EncodeHelper;
import MessageHelper.Message;

import java.util.Arrays;

public class ErrorCorrection {

    public static void parityBlockEncoding(Message message, int blockLength) { // Even parity
        String messageString = message.getMessageAsString();
        int[] messageArray = message.getMessageAsArray();
        int messageLength = messageArray.length;

        int numberOfBlocks = messageLength / blockLength;

        int[][] matrix = new int[numberOfBlocks + 1][blockLength + 1]; // +1 for parity bits

        // fill matrix with the message and calculate horizontal parity for each block
        for (int block = 0; block < numberOfBlocks; block++) {
            int horizontalParity = 0;
            for (int i = 0; i < blockLength; i++) {
                int index = block * blockLength + i;
                matrix[block][i] = messageArray[index];
                horizontalParity ^= messageArray[index]; // calculate horizontal parity
            }
            matrix[block][blockLength] = horizontalParity; // set horizontal parity bit
        }

        // Calculate vertical parity for each column
        for (int i = 0; i < blockLength; i++) {
            int verticalParity = 0;
            for (int block = 0; block < numberOfBlocks; block++) {
                verticalParity ^= matrix[block][i]; // calculate vertical parity
            }
            matrix[numberOfBlocks][i] = verticalParity; // set vertical parity bit
        }

        // Calculate the overall parity bit
        int overallParity = 0;
        for (int i = 0; i < blockLength; i++) {
            overallParity ^= matrix[numberOfBlocks][i]; // vertical parity bit
        }
        for (int block = 0; block < numberOfBlocks; block++) {
            overallParity ^= matrix[block][blockLength]; // horizontal parity bit
        }
        matrix[numberOfBlocks][blockLength] = overallParity; // Set parity col and row parity bit

        // Print the matrix with parity bits
        for (int block = 0; block <= numberOfBlocks; block++) {
            for (int i = 0; i <= blockLength; i++) {
                System.out.print(matrix[block][i] + " ");
            }
            System.out.println();
        }
    }
    public static boolean parityBlockVerify(Message message, int blockLength) {

    }
    public static Message hammingEncoding(Message message) {
        String messageString = message.getMessageAsString();
        int messageLength = message.getMessageAsArray().length; // Get actual message length
        int r = calculateRedundantBits(messageLength);

        int[] code = generateCode(messageString, messageLength, r);
        calculateParityBits(code, r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < code.length; i++) { // Skip index 0
            sb.append(code[i]);
        }
        return new Message(sb.toString());
    }
    public static boolean hammingVerify(Message message) {
        return true;
    }

    private static void calculateParityBits(int[] code, int r) {
        for (int i = 0; i < r; i++) {
            int parityPosition = (int) Math.pow(2, i);
            for (int j = 1; j < code.length; j++) {
                if (((j >> i) & 1) == 1 && parityPosition != j) {
                    code[parityPosition] ^= code[j];
                }
            }
        }
    }

    private static int[] generateCode(String message, int messageLength, int r) {
        int totalLength = messageLength + r;
        int[] code = new int[totalLength + 1];
        int messageIndex = 0;

        for (int i = 1; i <= totalLength; i++) {
            if (isPowerOfTwo(i)) {
                code[i] = 0;
            } else {
                code[i] = Character.getNumericValue(message.charAt(messageIndex));
                messageIndex++;
            }
        }
        return code;
    }

    private static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0 && x != 0;
    }

    private static int calculateRedundantBits(int messageLength) {
        int r = 0;
        while (Math.pow(2, r) < (messageLength + r + 1)) {
            r++;
        }
        return r;
    }
}