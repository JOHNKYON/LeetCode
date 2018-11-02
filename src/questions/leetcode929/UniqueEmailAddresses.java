package questions.leetcode929;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {
            String[] strs = email.split("@");
            String local = strs[0];
            String domain = strs[1];

            local = local.replace(".", "");

            int index = local.indexOf('+');

            if (index > 0)
                local = local.substring(0, index);

            StringBuilder sb = new StringBuilder();
            sb.append(local);
            sb.append('@');
            sb.append(domain);

            if (!set.contains(sb.toString()))
                set.add(sb.toString());
        }

        return set.size();
    }
}
