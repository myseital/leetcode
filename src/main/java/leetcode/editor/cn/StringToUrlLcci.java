package leetcode.editor.cn;

//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 👍 70 👎 0

public class StringToUrlLcci {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {

        if(S == null || S.length() == 0) {
            return S;
        }

        char [] str = S.toCharArray();
        int index = str.length - 1;
        for(int i=length - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
            }else{
                str[index--] = str[i];
            }
        }
        return new String(str, index + 1, str.length - index - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}