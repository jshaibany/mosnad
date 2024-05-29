package com.example.demo.helper;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



public class Cypher {

	public static String hashText(String text, String hashingAlgorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		  MessageDigest digest = MessageDigest.getInstance(hashingAlgorithm);
		  byte[] hashedBytes = digest.digest(text.getBytes("UTF-8"));
		  return Base64.getEncoder().encodeToString(hashedBytes);
		}
}
