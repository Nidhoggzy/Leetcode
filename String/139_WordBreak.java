class 139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用动态规划
        // 问题：子串[0-j]是否能拆分，如果子串[0-i](i<j)可以拆分，并且[i-j]在字典中，则[0-j]可以拆分
        //                         如果条件没满足，不一定不能拆分，取决于前面是否有可拆分的组合

        boolean[] canBreak = new boolean[s.length() + 1];
        HashSet<String> words = new HashSet<>(wordDict);

        canBreak[0] = true;

        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                // 如果能由子串和字典中的一个词拼接，则可以拼接；否则，保持原值
                canBreak[i] |= canBreak[j] && words.contains(s.substring(j, i));
            }
        }

        return canBreak[s.length()];
    }
}
