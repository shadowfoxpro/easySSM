package pro.shadowfox.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);


    /**
     * 生成文件名
     * 规则:yyyyMMddHHmmss_xxxx.ext
     * @param fileExt 指定文件后缀
     * @return
     */
    public static String genFileName(String fileExt) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
        return newFileName;
    }

    /**
     * 判断文件是否存在
     * @param filePath
     * @return boolean
     */
    public static boolean exists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 判断文件夹是否存在，不存在则创建并返回
     * @param filePath
     *            文件路径
     * @return
     */
    public static String isFileMkdir(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return filePath;
    }

    /**
     * 读取文件
     *
     * @param file
     * @return
     */
    public static String readFile(File file, String encode) {
        String output = "";

        if (file.exists()) {
            if (file.isFile()) {
                try {
                    InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encode);
                    BufferedReader input = new BufferedReader(isr);
                    StringBuffer buffer = new StringBuffer();
                    String text;
                    while ((text = input.readLine()) != null)
                        buffer.append(text + "\n");
                    output = buffer.toString();

                } catch (IOException ioException) {
                    System.err.println("File Error！");
                    LOG.error("read file error!");
                }
            } else if (file.isDirectory()) {
                String[] dir = file.list();
                output += "Directory contents：\n";
                for (int i = 0; null != dir && i < dir.length; i++) {
                    output += dir[i] + "\n";
                }
            }

        } else {
            System.err.println("Does not exist！");
            LOG.warn("file not exist!");
        }

        return output;
    }

    /**
     * 读取文件
     *
     * @param file
     * @return
     */
    public static String readFile(File file) {
        return readFile(file, "UTF-8");
    }

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     */
    public static String readFile(String fileName, String encode) {
        File file = new File(fileName);
        return readFile(file, encode);
    }

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     */
    public static String readFile(String fileName) {
        return readFile(fileName, "utf-8");
    }

    /**
     * 为图片添加水印
     * @param oldImagePath 需要添加logo的图片路径
     * @param logoPath logo图片路径
     *
     * @return 返回保存文件名
     * @throws IOException
     * @author hehu
     * @since 2014.07.02
     */
    public static void imageMarkLogo(final String oldImagePath, final String logoPath){

        try {
            File formerFile = new File(oldImagePath);
            Image formerImage = ImageIO.read(formerFile);
            //以下2行代码分别获得图片的宽(width)和高(height)
            int width = formerImage.getWidth(null);
            int height = formerImage.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(formerImage, 0, 0, width, height, null);

            File waterMarkFile = new File(logoPath);
            Image waterMarkImage = ImageIO.read(waterMarkFile);
            int widthWMI = waterMarkImage.getWidth(null);
            int heightWMI = waterMarkImage.getHeight(null);
            /**
             * 以下2行代码的x，y分别表示水印图片在原始图片的位置。
             * x,y为坐标。width，height为商品图片的宽和高。
             * width * 0.5 表示水印图片的水平位置覆盖在商品图片
             * 水平位置的正中间。height * 0.5 表示垂直位置。
             * 最终无论商品图片的宽高是多少，水印图片都会显示在
             * 商品图片的正中间。
             * 您可以根据您的需求，更改0.5这个数值，达到您想要的效果。
             * 这里我说的商品图片就是要被水印覆盖的图片。
             */
            int x = (int)(width * 0.02); //"0.5"小数越大，水印越向左移动。
            int y = (int)(height * 0.05); //"0.5"小数越大，水印越向上移动。
            g.drawImage(waterMarkImage, width - widthWMI - x, height - heightWMI - y, widthWMI,
                    heightWMI, null);
            g.dispose();

            /*FileOutputStream out = new FileOutputStream(oldImagePath);
            //下面代码将被加上水印的图片转换为JPEG、JPG文件
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();*/
            ImageIO.write(image, "PNG", new File(oldImagePath));
            image.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
