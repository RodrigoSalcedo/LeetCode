class LRUCache(object):

    def __init__(self,capacity):
        self.capacidad = capacity
        self.cache = {}
        self.ordenDeUso = []

    def get(self,key):
        if key not in self.cache:
            return -1
        self.ordenDeUso.remove(key)
        self.ordenDeUso.insert(0,key)
        return self.cache.get(key)

    def put(self,key,value):
        if key in self.cache:
            self.ordenDeUso.remove(key)
        elif len(self.cache)==self.capacidad:
            LRU = self.ordenDeUso.pop()
            del self.cache(LRU)
        self.ordenDeUso.insert(0,key)
        self.cache[key]= value
