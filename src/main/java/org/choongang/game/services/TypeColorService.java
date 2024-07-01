package org.choongang.game.services;

public class TypeColorService {
    public String getTypeColor(String type) {
        switch(type.toLowerCase()) {
            case "노말":
                return "normal";
            case "불꽃":
                return "fire";
            case "물":
                return "water";
            case "풀":
                return "grass";
            case "전기":
                return "electric";
            case "얼음":
                return "ice";
            case "격투":
                return "fighting";
            case "독":
                return "poison";
            case "땅":
                return "ground";
            case "비행":
                return "flying";
            case "에스퍼":
                return "psychic";
            case "벌레":
                return "bug";
            case "바위":
                return "rock";
            case "고스트":
                return "ghost";
            case "드래곤":
                return "dragon";
            case "악":
                return "dark";
            case "강철":
                return "steel";
            case "페어리":
                return "fairy";
            default:
                return "X";
        }
    }
}
