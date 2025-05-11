class Solution(object):
    def isMatch(self, s, p):
        i = 0
        j = 0

        while True:
            if i >= len(s) and j >= len(p):
                return True
            if j >= len(p):
                return False

            coincide = (i < len(s) and (s[i] == p[j] or p[j] == '.'))

            if (j + 1) < len(p) and p[j + 1] == '*':
                if self.isMatch(s[i:], p[j + 2:]):
                    return True
                while i < len(s) and (s[i] == p[j] or p[j] == '.'):
                    if self.isMatch(s[i + 1:], p[j + 2:]):
                        return True
                    i += 1
                j += 2
            elif coincide:
                i += 1
                j += 1
            else:
                return False
