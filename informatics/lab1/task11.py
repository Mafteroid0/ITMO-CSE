
def fibonacci(n: int) -> list[int]:
    n += 2
    arr = [0, 1]
    while len(arr) < n:
        arr.append(arr[-1] + arr[-2])
    return arr[2:n]
def algo(c: str) -> int:
    out = 0
    c = c[::-1]
    fibs = fibonacci(len(c))
    for i in range(len(c)):
        out += int(c[i])*fibs[i]
    return out


print(algo(input()))