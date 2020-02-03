package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void helper(int k, int n, int st, List<Integer> temp, List<List<Integer>> res) {
        if (k == 1) {
            if (st <= n && n <= 9) {
                temp.add(n);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }

        for (int i = st; i < Math.min(10, (n - i) / (k - 1)); i++) {
            temp.add(i);
            helper(k - 1, n - i, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}