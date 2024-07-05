package com.echo.graphics;

public class InvalidAlbumName extends Exception {
    public InvalidAlbumName() {
        super("O album não foi econtrado! Por favor digite um nome válido");
    }
    
}
