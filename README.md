# Payroll Processing
Project #2 for Rutgers Software Methodology


### Testing
```bash
(src/)          $ javac -d ./build *.java
(src/build/)    $ cd build
(src/build/)    $ cat ./../raw\ input.txt | java RunProject2 > actual.txt
(src/build/)    $ diff -y actual.txt ./../expected.txt --width=250
```