public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordList = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordList.addLast(word.charAt(i));
        }
        return wordList;
    }

    private boolean isPalindrome(Deque<Character> wordList) {
        if (wordList.size() <= 1) {
            return true;
        }
        if (wordList.removeFirst() != wordList.removeLast()) {
            return false;
        }
        return isPalindrome(wordList);
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> wordList, CharacterComparator cc) {
        if (wordList.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(wordList.removeFirst(), wordList.removeLast())) {
            return false;
        }
        return isPalindrome(wordList, cc);

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);

    }

}
