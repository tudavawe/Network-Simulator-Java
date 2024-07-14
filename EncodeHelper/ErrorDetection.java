package EncodeHelper;

import MessageHelper.Message;

import java.util.Arrays;

public class ErrorDetection {
    public static Message parityBitsEncoding(Message message, int blockLength) {
        int[] mes = message.getMessageAsArray();
        int[] newMes = new int[mes.length + mes.length / blockLength];
        for(int i = 0; i < mes.length / blockLength; ++i) {
            int x = 0;
            for(int j = 0; j < blockLength; ++j) {
                newMes[i * blockLength + j + i] = mes[i * blockLength + j];
                x = x ^ mes[i * blockLength + j];
            }
            newMes[(i + 1) * blockLength + i] = x;
        }
        return new Message(Arrays.toString(newMes));
    }

    public static boolean parityBitsVerify(Message message, int blockLength) {
        int[] mes = message.getMessageAsArray();
        for (int i = 0; i < mes.length / (blockLength + 1); ++i) {
            int x = 0;
            for (int j = 0; j < blockLength; ++j) {
                x = x ^ mes[i * (blockLength + 1) + j];
            }
            if (x != mes[(i + 1) * (blockLength + 1) - 1]) {
                return false;
            }
        }
        return true;
    }

    public static Message crcEncoding(Message message) {
        String generator = "10001000000100001";
        String data = message.getMessageAsString();
        int dataLength = data.length();
        int generatorLength = generator.length();

        // Append zeros to the data based on the length of the generator polynomial
        String appendedData = data + "0".repeat(generatorLength - 1);

        // Perform division using the generator polynomial
        String remainder = divide(appendedData, generator);

        // The CRC code is the original data plus the remainder
        return new Message(data + remainder);
    }

    public static boolean crcVerify(Message message) {
        String generator = "10001000000100001";
        String receivedData = message.getMessageAsString();
        String remainder = divide(receivedData, generator);

        // If the remainder is all zeros, the data is valid
        return remainder.chars().allMatch(c -> c == '0');
    }

    private static String divide(String data, String generator) {
        int dataLength = data.length();
        int generatorLength = generator.length();
        char[] remainder = data.toCharArray();

        for (int i = 0; i <= dataLength - generatorLength; i++) {
            // Only perform XOR if the current bit is 1
            if (remainder[i] == '1') {
                for (int j = 0; j < generatorLength; j++) {
                    remainder[i + j] = (char) ((remainder[i + j] - '0') ^ (generator.charAt(j) - '0') + '0');
                }
            }
        }

        // Extract the remainder part (last generatorLength-1 bits)
        StringBuilder result = new StringBuilder();
        for (int i = dataLength - generatorLength + 1; i < dataLength; i++) {
            result.append(remainder[i]);
        }

        return result.toString();
    }
}
