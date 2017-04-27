/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class UpdateFileUpload {
    public static String path = null;
    //public static String im = null;
    private static final int IMG_WIDTH = 160;
    private static final int IMG_HEIGHT = 160;
    public static boolean processFile(String path,FileItemStream item, int id){
        try{
            String check = item.getName();
            if(check.endsWith(".jpg")||check.endsWith(".JPG"))
            {   
                String imstring = "images/"+Integer.toString(id);
                File f = new File(path+File.separator+imstring);
                if (!f.exists())
                    f.mkdir();
                File savedFile = new File(f.getAbsolutePath()+File.separator+item.getName());
                FileOutputStream fos =  new FileOutputStream(savedFile);
                InputStream is = item.openStream();
                int x =0;
                byte[] b = new byte[1024];
                while ( ( x=is.read(b) ) != -1){
                    fos.write(b,0,x);
                }
                fos.flush();
                fos.close();
                String dbimage = imstring+"/a.jpg";
                //dc.enterImage(dbimage);
                //im =dbimage;
                //System.out.println("Resizing!");
                //Resize rz = new Resize();
                //rz.resize(dbimage);
                BufferedImage originalImage = ImageIO.read(savedFile);
                int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                BufferedImage resizeImageJpg = resizeImage(originalImage, type);
                ImageIO.write(resizeImageJpg, "jpg", savedFile);
                File rFile = new File(f.getAbsolutePath()+"/a.jpg");
                savedFile.renameTo(rFile);
                ProfileEditDB dc = new ProfileEditDB();
                dc.enterImage(id, dbimage);
                System.out.println("Link Entered to Database!");
                return true;
            }
            
        }   
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type)
    {
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();	
	return resizedImage;
    }
}