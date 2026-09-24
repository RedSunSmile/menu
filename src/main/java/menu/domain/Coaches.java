package menu.domain;

public class Coaches {


    private void validateNumbersOfCoaches(int numbers){
        boolean n=!(numbers>=2 && numbers<=5);
        if(n){
            throw new IllegalArgumentException("[ERROR] 식사 가능한 인원은 최소 2명이어야 합니다.");
        }else if(n){
            throw new IllegalArgumentException("[ERROR] 식사 가능한 인원은 최대 5명까지 가능합니다.");
        }
    }
}
