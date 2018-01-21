package com.keyfalcon.blockchain.config;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;

import org.bouncycastle.util.encoders.Hex;

public class HashUtil {

	private static final MessageDigest digest;

	static {

		try {

			digest = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException(e); // Can't happen.

		}

	}

	/**
	 * 
	 * See {@link HashUtils#doubleDigest(byte[], int, int)}.
	 * 
	 */

	public static byte[] doubleDigest(byte[] input) {

		return doubleDigest(input, 0, input.length);

	}

	/**
	 * 
	 * Calculates the SHA-256 hash of the given byte range, and then hashes the
	 * resulting hash again. This is
	 * 
	 * standard procedure in Bitcoin. The resulting hash is in big endian form.
	 * 
	 */

	public static byte[] doubleDigest(byte[] input, int offset, int length) {

		synchronized (digest) {

			digest.reset();

			digest.update(input, offset, length);

			byte[] first = digest.digest();

			return digest.digest(first);

		}

	}

	public static byte[] SHA256_RIPEMD160(byte[] input) {

		try {

			byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(input);

			RIPEMD160Digest digest = new RIPEMD160Digest();

			digest.update(sha256, 0, sha256.length);

			byte[] out = new byte[20];

			digest.doFinal(out, 0);

			return out;

		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException(e); // Cannot happen.

		}

	}

	public static void main(String[] args) {

		System.out.println(Hex.encode(HashUtil.SHA256_RIPEMD160("cow".getBytes())));

	}

}
