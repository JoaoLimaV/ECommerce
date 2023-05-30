package Crud;

public class FormatJson {
    public static String formatJson(String jsonString) {
        StringBuilder formattedJson = new StringBuilder();

        int indentLevel = 0;
        for (char c : jsonString.toCharArray()) {
            if (c == '{' || c == '[') {
                formattedJson.append(c).append("\n");
                indentLevel++;
                appendIndentation(formattedJson, indentLevel);
            } else if (c == '}' || c == ']') {
                formattedJson.append("\n");
                indentLevel--;
                appendIndentation(formattedJson, indentLevel);
                formattedJson.append(c);
            } else if (c == ',') {
                formattedJson.append(c).append("\n");
                appendIndentation(formattedJson, indentLevel);
            } else {
                formattedJson.append(c);
            }
        }

        return formattedJson.toString();
    }

    private static void appendIndentation(StringBuilder stringBuilder, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            stringBuilder.append("    ");
        }
    }
}