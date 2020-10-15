package exam.bianlifeng;

import java.util.*;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/10/10 20:40
 */
public class DependCount {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            count = 0;
            Map<String, Module> map = new HashMap<>();
            String targetName = cin.nextLine();
            map.put(targetName, new Module(targetName));
            int n = cin.nextInt();
            cin.nextLine();
            for (int i = 0; i < n; i++) {
                String line = cin.nextLine();
                String[] strs = line.split("\\s");
                if (!map.containsKey(strs[0])) {
                    Module module1 = new Module(strs[0]);
                    map.put(strs[0], module1);
                }
                if (!map.containsKey(strs[1])) {
                    Module module2 = new Module(strs[1]);
                    map.put(strs[1], module2);
                }
                map.get(strs[0]).dependencies.add(map.get(strs[1]));
            }
            for (Module temp: map.get(targetName).dependencies) {
                countDependencies(temp, targetName);
            }

            System.out.println(count);
        }
    }

    public static int count = 0;
    public static void countDependencies(Module module, String targetName) {
        if (module == null) return;
        if (module.name.equals(targetName)) {
            return;
        }
        count += module.dependencies.size();
        for (Module temp: module.dependencies) {
                countDependencies(temp, targetName);
        }
    }
}

class Module {
    String name;
    List<Module> dependencies;

    public Module(String name) {
        this.name = name;
        this.dependencies = new ArrayList<>();
    }
}
