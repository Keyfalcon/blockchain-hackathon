package com.itgrids.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class ImageUtility {

	public static String saveImage(String imagesPath, String storeFolder, String base64Image) {

		// String base64Image = base64Image1.split(",")[1];

		String uuid = UUID.randomUUID().toString();

		String userDirectory = uuid + System.currentTimeMillis();

		String finalDlfile = null;
		String imgeurlfile = null;

		try {

			String dlpath = null;

			if (storeFolder.equals("Location_Images")) {
				dlpath = imagesPath + "/" + "Location_Images";
				imgeurlfile = "/" + "Location_Images";
			}

			if (storeFolder.equals("Verified_Images")) {
				dlpath = imagesPath + "/" + "Verified_Images";
				imgeurlfile = "/" + "Verified_Images";
			}

			if (storeFolder.equals("Location_Images")) {
				dlpath = imagesPath + "/" + "Location_Images";
				imgeurlfile = "/" + "Location_Images";
			}

			File destDlFile = new File(dlpath);

			if (!destDlFile.exists())
				destDlFile.mkdirs();

			finalDlfile = dlpath + "/" + userDirectory;
			imgeurlfile = imgeurlfile + "/" + userDirectory;

			byte[] dlByteArray = Base64.decodeBase64(base64Image.getBytes());

			FileOutputStream dlOutFile;
			dlOutFile = new FileOutputStream(finalDlfile);
			dlOutFile.write(dlByteArray);
			dlOutFile.close();
			System.out.println(finalDlfile);
			System.out.println(userDirectory);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgeurlfile;
	}

}
