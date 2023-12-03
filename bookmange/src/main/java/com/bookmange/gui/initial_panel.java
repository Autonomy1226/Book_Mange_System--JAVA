package com.bookmange.gui;

import javax.swing.*;
import java.awt.*;
public class initial_panel extends JPanel {
    private ImageIcon imageIcon;
    private Image scaledImage;
    private String imagePath;
    public initial_panel(String imagePath)
    {
        imageIcon=new ImageIcon(imagePath);
        setPreferredSize(new Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
        scaledImage = imageIcon.getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (scaledImage != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // 计算比例缩放后的图片尺寸
            int imgWidth = scaledImage.getWidth(this);
            int imgHeight = scaledImage.getHeight(this);

            double panelAspectRatio = (double) panelWidth / panelHeight;
            double imgAspectRatio = (double) imgWidth / imgHeight;

            int x = 0;
            int y = 0;
            int width = panelWidth;
            int height = panelHeight;

            if (panelAspectRatio > imgAspectRatio) {
                height = (int) (width / imgAspectRatio);
                y = (panelHeight - height) / 2;
            } else {
                width = (int) (height * imgAspectRatio);
                x = (panelWidth - width) / 2;
            }

            // 绘制图片
            g.drawImage(scaledImage, x, y, width, height, this);
        }
    }
}
