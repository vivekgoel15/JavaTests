package com.test.designpatterns.structural.composite;

import java.util.ArrayList;

public class CompositePatternDemo2 {
	public static StringBuffer compositeBuilder = new StringBuffer();

	public static void main(String[] args) {
		Directory music = new Directory("MUSIC");
		Directory scorpions = new Directory("SCORPIONS");
		Directory dio = new Directory("DIO");
		File track1 = new File("Don't wary, be happy.mp3");
		File track2 = new File("track2.m3u");
		File track3 = new File("Wind of change.mp3");
		File track4 = new File("Big city night.mp3");
		File track5 = new File("Rainbow in the dark.mp3");
		music.add(track1);
		music.add(scorpions);
		music.add(track2);
		scorpions.add(track3);
		scorpions.add(track4);
		scorpions.add(dio);
		dio.add(track5);
		music.ls();
	}
}

// Define a "lowest common denominator"
interface AbstractFile {
	void ls();
}

// File implements the "lowest common denominator"
class File implements AbstractFile {
	private String name;

	public File(String name) {
		this.name = name;
	}

	public void ls() {
		System.out.println(CompositePatternDemo2.compositeBuilder + name);
	}
}

// Directory implements the "lowest common denominator"
class Directory implements AbstractFile {
	private String name;
	private ArrayList includedFiles = new ArrayList();

	public Directory(String name) {
		this.name = name;
	}

	public void add(Object obj) {
		includedFiles.add(obj);
	}

	public void ls() {
		System.out.println(CompositePatternDemo2.compositeBuilder + name);
		CompositePatternDemo2.compositeBuilder.append("   ");
		for (Object includedFile : includedFiles) {
			// Leverage the "lowest common denominator"
			AbstractFile obj = (AbstractFile) includedFile;
			obj.ls();
		}
		CompositePatternDemo2.compositeBuilder.setLength(CompositePatternDemo2.compositeBuilder.length() - 3);
	}
}
