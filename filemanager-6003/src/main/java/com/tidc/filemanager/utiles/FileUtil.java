package com.tidc.filemanager.utiles;

import com.tidc.filemanager.properties.MatchProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

/**
 * @ClassNmae FileUtile
 * @Description TODO
 * @Author 冯涛滔
 **/
public class FileUtil {
	@Autowired
	private MatchProperties matchProperties;
	/**
	 * 匹配文件类型
	 * @param fileType  匹配格式：  自定义 ".jsp, .ppt"
	 * @param fileName  文件名
	 * @return boolean
	 */
	public boolean isNumType(String fileType,String fileName){
		if (fileType!=null && fileName!=null){
			String substring = fileName.substring(fileName.indexOf("."));  //获取文件后缀名（判断类型）
			System.out.println("文件上传类型是："+substring);
			String[] str = fileType.split(",");                     //截取出来后缀名 也就是要匹配什么类型
			System.out.println(Arrays.toString(str));
			for (String s : str) {//遍历是否符合后缀
				if (substring.equals(s))  return true;
			}
			return false;
		}
		return false;
	}
	/**
	 * 保存文件
	 * @param path  存储得绝对路径
	 * @param file  文件
	 * @param fileName 自定义文件名字
	 * @return  存储的绝对路径
	 */
	public static String saveFile(String path, MultipartFile file, String fileName) throws IOException {
		//判断文件夹是否存在，动态创建
		File file1 = new File(path);
		if (file1.exists()) {
			file1.mkdirs();
		}
		//生成唯一ID名
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		//获取文件的名称
		String UploadName = file.getOriginalFilename();
		//获取文件后缀名
		String fileType = UploadName.substring(UploadName.indexOf("."));
		//创建文件名
		String UuidFilename = fileName+uuid+fileType;
		//完成文件上传
		file.transferTo(new File(path,UuidFilename));
		//是否成功存 入

		return new File(path+"\\"+UuidFilename).exists() ? UuidFilename : null;

	}
	/**
	 *保存文件
	 * @param relativePath  存储相对路径，将存在/WEB-INF/File/下
	 * @param file  文件,自动生成一个唯一ID
	 * @return 存储的绝对路径
	 */
	public String saveFile(String relativePath, MultipartFile file){
		try {
			//项目绝对路径
			String path = this.getProjectAbsolutePath();
			path = path+"File\\"+relativePath;
			//判断文件夹是否存在，动态创建
			File file1 = new File(path);
			if (!file1.exists()) {
				file1.mkdirs();
			}
			//获取文件的名称
			String UploadName = file.getOriginalFilename();
			//获取文件后缀名
			String fileType = UploadName.substring(UploadName.indexOf("."));
			//生成唯一ID名
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//创建文件名
			String UuidFilename = uuid+fileType;
			//完成文件上传
			file.transferTo(new File(path,UuidFilename));
			//是否成功存入
			return new File(path+UuidFilename).exists() ? path+UuidFilename : null;
		} catch (IOException e) {
			return null;
		}
	}
	/**
	 * 获得当前WEB-INF的绝对路径
	 * @return
	 */
	public String getProjectAbsolutePath(){
		//file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
		String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
		path=path.replace('/', '\\'); // 将/换成\
		path=path.replace("file:", ""); //去掉file:
		path=path.replace("classes\\", ""); //去掉class\
		path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...
		return path;
	}


	/**
	 * @param resp
	 * @param path         文件的绝对路径
	 * @param downloadName 文件下载的名字  自定义名字
	 */
	public void downloadFile(final HttpServletResponse resp, final String path, final String downloadName) throws Exception{
		String fileName = null;
		try {
			fileName = new String(downloadName.getBytes("GBK"), StandardCharsets.ISO_8859_1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		final File file = new File(path);
		resp.reset();
		resp.setContentType("application/octet-stream");
		resp.setCharacterEncoding("utf-8");
		resp.setContentLength((int) file.length());
		resp.setHeader("Content-Disposition", "attachment;filename=" +fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = resp.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(file));
			int i = 0;
			while ((i = bis.read(buff)) != -1) {
				os.write(buff, 0, i);
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis!=null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (os!=null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//删除文件 单个文件删除成功返回true，否则返回false
	public  boolean deleteFile(String fileName) {
		fileName = matchProperties.getFileProperties().getFilePath();
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}
}
