package combinations;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();

        if (k > n || n == 0 || k == 0){
            return null;
        }
        else {
            back(1, n, k, res, new ArrayList<>());
        }

        return res;
    }

    public void back(int begin, int n, int k, List<List<Integer>> res, List<Integer> list){
        if (k == 0){
            List<Integer> tmp = new ArrayList<>(list);
            res.add(tmp);
        }
        else {
            for (int i = begin; i <= n-k+1; i++){
                list.add(i);
                back(i+1, n, k-1, res, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Combine t = new Combine();
        int n = 4, k = 0;
        List<List<Integer>> res = t.combine(n, k);
        for (int i = 0; i < res.size(); i++){
            for (int j = 0; j < k; j++){
                System.out.print(res.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
