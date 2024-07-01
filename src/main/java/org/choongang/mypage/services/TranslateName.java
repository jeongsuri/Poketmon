package org.choongang.mypage.services;

public class TranslateName {
    public String koreanName(String type) {
        switch (type) {
            case "normal":
                return "노말";
            case "fire":
                return "불꽃";
            case "water":
                return "물";
            case "grass":
                return "풀";
            case "electric":
                return "전기";
            case "ice":
                return "얼음";
            case "fighting":
                return "격투";
            case "poison":
                return "독";
            case "ground":
                return "땅";
            case "flying":
                return "비행";
            case "psychic":
                return "에스퍼";
            case "bug":
                return "벌레";
            case "rock":
                return "바위";
            case "ghost":
                return "고스트";
            case "dragon":
                return "드래곤";
            case "dark":
                return "악";
            case "steel":
                return "강철";
            case "fairy":
                return "페어리";
            default:
                return "없음";
        }
    }

}
