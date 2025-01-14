def hamming(code: str) -> str:
    if len(code) != 7:
        return "Длина кода должна равняться 7"
    code = list(map(int, list(code)))
    s1 = code[0] ^ code[2] ^ code[4] ^ code[6]
    s2 = code[1] ^ code[2] ^ code[5] ^ code[6]
    s3 = code[3] ^ code[4] ^ code[5] ^ code[6]
    err = f'{s3}{s2}{s1}'

    if err == '000':
        return 'Код не содержит ошибок'
    else:
        bit = int(err, 2) - 1
        code[bit] = 0 if code[bit] == 1 else 1
        right = "".join(map(str, code))
        return (f'Ошибка в {bit+1} бите. Исходное сообщение:\n'
                f'{right[2]}{right[4:]}')

while True:
    print(hamming(input()))
