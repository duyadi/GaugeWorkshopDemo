import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import java.util.HashSet;
import java.util.Iterator;
import org.junit.Assert;

public class StepImplementation {
    private HashSet<Character> vowels;

    public StepImplementation() {
    }

    @Step({"Vowels in English language are <vowelString>."})
    public void setLanguageVowels(String vowelString) {
        this.vowels = new HashSet();
        char[] var2 = vowelString.toCharArray();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            char ch = var2[var4];
            this.vowels.add(Character.valueOf(ch));
        }

    }

    @Step({"The word <word> has <expectedCount> vowels."})
    public void verifyVowelsCountInWord(String word, int expectedCount) {
        int actualCount = this.countVowels(word);
        Assert.assertEquals((long) expectedCount, (long) actualCount);
    }

    @Step({"Almost all words have vowels <wordsTable>"})
    public void verifyVowelsCountInMultipleWords(Table wordsTable) {
        Iterator var2 = wordsTable.getTableRows().iterator();

        while (var2.hasNext()) {
            TableRow row = (TableRow) var2.next();
            String word = row.getCell("Word");
            int expectedCount = Integer.parseInt(row.getCell("Vowel Count"));
            int actualCount = this.countVowels(word);
            Assert.assertEquals((long) expectedCount, (long) actualCount);
        }

    }

    private int countVowels(String word) {
        int count = 0;
        char[] var3 = word.toCharArray();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            char ch = var3[var5];
            if (this.vowels.contains(Character.valueOf(ch))) {
                ++count;
            }
        }

        return count;
    }

}

