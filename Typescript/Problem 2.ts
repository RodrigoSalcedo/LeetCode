class LRUCache {
    private capacidad: number;
    private cache: Map<number, number>;
    private ordenDeUso: number[];

    constructor(capacity: number) {
        this.capacidad = capacity;
        this.cache = new Map();
        this.ordenDeUso = [];
    }

    get(key: number): number {
        if (!this.cache.has(key)) {
            return -1;
        }
        this.ordenDeUso = this.ordenDeUso.filter(k => k !== key);
        this.ordenDeUso.unshift(key);
        return this.cache.get(key)!;
    }

    put(key: number, value: number): void {
        if (this.cache.has(key)) {
            this.ordenDeUso = this.ordenDeUso.filter(k => k !== key);
        } else if (this.cache.size === this.capacidad) {
            const LRU = this.ordenDeUso.pop()!;
            this.cache.delete(LRU);
        }
        this.ordenDeUso.unshift(key);
        this.cache.set(key, value);
    }
}
