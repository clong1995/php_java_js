package image;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * 
 * @author clong
 * @version V1.0
 */
public class Image {
	/**
	 * 拼接图片 : merge({ "I:/1.jpg", "I:/2.jpg", "I:/3.jpg" }, "jpg", "I:/test2.jpg");
	 * @param imgs 图片绝对路径数组
	 * @param type 图片类型
	 * @param dst_pic 生成后的绝对地址
	 */
	public static void merge(String[] imgs, String type, String dst_pic) {
		// 获取需要拼接的图片长度
		int len = imgs.length;
		// 文件数组
		File[] src = new File[len];
		// 图片数组
		BufferedImage[] images = new BufferedImage[len];

		// 二维不定长数组
		int[][] ImageArrays = new int[len][];
		for (int i = 0; i < len; ++i) {
			try {
				// 将资源读入文件数组
				src[i] = new File(imgs[i]);
				// 将文件资源读入图片，这样可以对图片文件操作
				images[i] = ImageIO.read(src[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 获取图片信息
			int width = images[i].getWidth();
			int height = images[i].getHeight();
			// 从图片中读取RGB 像素
			ImageArrays[i] = new int[width * height];
			ImageArrays[i] = images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);
		}

		int dst_height = 0;
		int dst_width = images[0].getWidth();
		// 合成图片像素，取最大的图片宽度为图片宽度
		for (int i = 0; i < len; ++i) {
			int tempWidth = images[i].getWidth();
			dst_width = dst_width > tempWidth ? dst_width : tempWidth;
			dst_height += images[i].getHeight();
		}
		// 生成新图片
		try {
			// dst_width = images[0].getWidth();
			BufferedImage ImageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TYPE_INT_RGB);
			int height_i = 0;
			for (int i = 0; i < len; ++i) {
				// 累加图片
				ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(), ImageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}
			// 输出图片文件
			File outFile = new File(dst_pic);
			// 写图片 ，输出到硬盘
			ImageIO.write(ImageNew, type, outFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


