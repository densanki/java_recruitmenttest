
# Recruitment Test Application

## About

Anagram Programm that find the right ones.

An anagram is direct word switch or word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, using all the original letters exactly once; for example, the word anagram can be rearranged into "nag a ram".
The original word or phrase is known as the subject of the anagram. Any word or phrase that exactly reproduces the letters in another order is an anagram. Someone who creates anagrams may be called an "anagrammatist",[1] and the goal of a serious or skilled anagrammatist is to produce anagrams that in some way reflect or comment on their subject.
Anagrams are often used as a form of mnemonic device.

## Install 

1. Java 1.8 Install
[https://java.com/de/download/]

2. Maven Install
[https://maven.apache.org/install.html]

3. Build application
```
mvn clean compile package
```

4. Run application
```
With sample file:
java -jar target\recruitment-test-1.0-SNAPSHOT-jar-with-dependencies.jar

With external file on target folder (hint will be removed on maven clean)
java -jar target\recruitment-test-1.0-SNAPSHOT-jar-with-dependencies.jar sample1.txt

With external bigger file on main folder
java -jar target\recruitment-test-1.0-SNAPSHOT-jar-with-dependencies.jar ..\densankisample.txt
```