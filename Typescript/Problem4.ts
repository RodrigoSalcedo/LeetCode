function isMatch(s: string, p: string): boolean {
    let i = 0;
    let j = 0;

    while (true) {
        if (i >= s.length && j >= p.length) {
            return true;
        }
        if (j >= p.length) {
            return false;
        }

        const coincide = (i < s.length && (s[i] === p[j] || p[j] === '.'));

        if ((j + 1) < p.length && p[j + 1] === '*') {
            if (isMatch(s.substring(i), p.substring(j + 2))) {
                return true;
            }
            while (i < s.length && (s[i] === p[j] || p[j] === '.')) {
                if (isMatch(s.substring(i + 1), p.substring(j + 2))) {
                    return true;
                }
                i++;
            }
            j += 2;
        } else if (coincide) {
            i++;
            j++;
        } else {
            return false;
        }
    }
}
