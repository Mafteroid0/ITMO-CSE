

## Лабораторная работа 1

Вариант `31959`

1. Создать одномерный массив f типа long. Заполнить его числами от 3 до 16 включительно в порядке возрастания.
2. Создать одномерный массив x типа float. Заполнить его 10-ю случайными числами в диапазоне от -11.0 до 13.0.
3. Создать двумерный массив f размером 14x10. Вычислить его элементы по следующей формуле (где x = x[j]):
    - если f[i] = 5, то <math xmlns="http://www.w3.org/1998/Math/MathML">
  <semantics>
    <mstyle displaystyle="true">
      <mi>f</mi>
      <mrow>
        <mo>[</mo>
        <mi>i</mi>
        <mo>]</mo>
      </mrow>
      <mrow>
        <mo>[</mo>
        <mi>j</mi>
        <mo>]</mo>
      </mrow>
      <mo>=</mo>
      <mrow>
        <mi>ln</mi>
        <mrow>
          <mo>(</mo>
          <mrow>
            <msup>
              <mi>cos</mi>
              <mn>2</mn>
            </msup>
            <mrow>
              <mo>(</mo>
              <msup>
                <mrow>
                  <mo>(</mo>
                  <mn>0.25</mn>
                  <mo>&#x22C5;</mo>
                  <mrow>
                    <mi>arctan</mi>
                    <mrow>
                      <mo>(</mo>
                      <mfrac>
                        <mrow>
                          <mi>x</mi>
                          <mo>+</mo>
                          <mn>1</mn>
                        </mrow>
                        <mn>24</mn>
                      </mfrac>
                      <mo>)</mo>
                    </mrow>
                  </mrow>
                  <mo>)</mo>
                </mrow>
                <mrow>
                  <mrow>
                    <mi>arcsin</mi>
                    <mrow>
                      <mo>(</mo>
                      <mfrac>
                        <mrow>
                          <mi>x</mi>
                          <mo>+</mo>
                          <mn>1</mn>
                        </mrow>
                        <mn>24</mn>
                      </mfrac>
                      <mo>)</mo>
                    </mrow>
                  </mrow>
                </mrow>
              </msup>
              <mo>)</mo>
            </mrow>
          </mrow>
          <mo>)</mo>
        </mrow>
      </mrow>
    </mstyle>
    <annotation encoding="text/x-asciimath">f[i][j] = ln(cos^2((0.25*arctan((x+1)/24))^(arcsin((x+1)/24))))</annotation>
  </semantics>
</math>
    - если f[i] ∈ {3, 4, 6, 8, 9, 12, 15}, то <math xmlns="http://www.w3.org/1998/Math/MathML">
  <semantics>
    <mstyle displaystyle="true">
      <mi>f</mi>
      <mrow>
        <mo>[</mo>
        <mi>i</mi>
        <mo>]</mo>
      </mrow>
      <mrow>
        <mo>[</mo>
        <mi>j</mi>
        <mo>]</mo>
      </mrow>
      <mo>=</mo>
      <mi>&#x3C0;</mi>
      <mo>&#x22C5;</mo>
      <mrow>
        <mi>arctan</mi>
        <mrow>
          <mo>(</mo>
          <mfrac>
            <mn>1</mn>
            <msup>
              <mi>e</mi>
              <mrow>
                <mrow>
                  <mo>|</mo>
                  <mrow>
                    <mi>x</mi>
                  </mrow>
                  <mo>|</mo>
                </mrow>
              </mrow>
            </msup>
          </mfrac>
          <mo>)</mo>
        </mrow>
      </mrow>
    </mstyle>
    <annotation encoding="text/x-asciimath">f[i][j] = pi*arctan(1/e^(abs(x)))</annotation>
  </semantics>
</math>
    
    - для остальных значений f[i]:  <math xmlns="http://www.w3.org/1998/Math/MathML">
  <semantics>
    <mstyle displaystyle="true">
      <mi>f</mi>
      <mrow>
        <mo>[</mo>
        <mi>i</mi>
        <mo>]</mo>
      </mrow>
      <mrow>
        <mo>[</mo>
        <mi>j</mi>
        <mo>]</mo>
      </mrow>
      <mo>=</mo>
      <mrow>
        <mi>arctan</mi>
        <mrow>
          <mo>(</mo>
          <mrow>
            <mi>cos</mi>
            <mrow>
              <mo>(</mo>
              <msup>
                <mrow>
                  <mo>(</mo>
                  <mfrac>
                    <mrow>
                      <mi>arctan</mi>
                      <mrow>
                        <mo>(</mo>
                        <mfrac>
                          <mn>1</mn>
                          <msup>
                            <mi>e</mi>
                            <mrow>
                              <mrow>
                                <mo>|</mo>
                                <mrow>
                                  <mi>x</mi>
                                </mrow>
                                <mo>|</mo>
                              </mrow>
                            </mrow>
                          </msup>
                        </mfrac>
                        <mo>)</mo>
                      </mrow>
                    </mrow>
                    <mrow>
                      <mrow>
                        <mi>tan</mi>
                        <mrow>
                          <mo>(</mo>
                          <mrow>
                            <mi>ln</mi>
                            <mrow>
                              <mo>(</mo>
                              <mrow>
                                <mo>|</mo>
                                <mrow>
                                  <mi>x</mi>
                                </mrow>
                                <mo>|</mo>
                              </mrow>
                              <mo>)</mo>
                            </mrow>
                          </mrow>
                          <mo>)</mo>
                        </mrow>
                      </mrow>
                      <mo>+</mo>
                      <mn>1</mn>
                    </mrow>
                  </mfrac>
                  <mo>)</mo>
                </mrow>
                <mn>2</mn>
              </msup>
              <mo>)</mo>
            </mrow>
          </mrow>
          <mo>)</mo>
        </mrow>
      </mrow>
    </mstyle>
    <annotation encoding="text/x-asciimath">f[i][j] = arctan(cos((arctan(1/e^(abs(x)))/(tan(ln(abs(x)))+1))^2))</annotation>
  </semantics>
</math>

---
## Текст задания

Написать программу на языке Java, выполняющую указанные в варианте действия.

Требования к программе:

1. Программа должна корректно запускаться, выполняться и выдавать результат. Программа не должна выдавать ошибки. Программа должна быть работоспособной именно во время проверки, то, что она работала 5 минут назад, дома или в параллельной вселенной оправданием не является.
2. Выражение должно вычисляться в соответствии с правилами вычисления математических выражений (должен соблюдаться порядок выполнения действий и т.д.).
3. Программа должна использовать математические функции из стандартной библиотеки Java.
4. Вычисление очередного элемента двумерного массива должно быть реализовано в виде отдельного статического метода.
5. Результат вычисления выражения должен быть выведен в стандартный поток вывода в виде матрицы с элементами в указанном в варианте формате. Вывод матрицы реализовать в виде отдельного статического метода.
6. Программа должна быть упакована в исполняемый jar-архив.
7. Выполнение программы необходимо продемонстрировать на сервере `helios`.

Примечания:

1. В случае, если в варианте будут предложены одинаковые имена массивов, для одного из них к имени добавить "1".
2. Если в результате вычислений иногда получается NaN - возможно так и должно быть.

---
#### Компиляция
```
javac -d out src/Main.java
```
#### Cборка Jar
```
jar cfe dist/app.jar Main -C out .
```
#### Запуск
```
java -jar dist/app.jar
```