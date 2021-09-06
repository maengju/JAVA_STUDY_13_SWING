package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class DrCanvas extends Canvas {
	private MsPaint msPaint;
	private Image bufferImage;
	private Graphics bufferG;
	
	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255,200,255));
	}
	
	@Override
	public void update(Graphics g) {
		Dimension d = this.getSize();
		if(bufferG == null) {
			bufferImage = this.createImage(d.width, d.height); //Canvas ũ��� �Ȱ���
			bufferG = bufferImage.getGraphics();
		}
		
		//�����
		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0, 0, d.width, d.height);
		
		int x1, y1, x2, y2, z1, z2;
		
		// list�� ����ִ� ShapeDTO�� (������ �׷ȴ� ������) �ϳ��� ������ �ٽ� �׸���
		for(ShapeDTO dto : msPaint.getList()) {
			//��ǥ
			x1 = dto.getX1();
			y1 = dto.getY1();
            x2 = dto.getX2();
            y2 = dto.getY2();
            z1 = dto.getZ1();
            z2 = dto.getZ2();

			//��
            switch(dto.getColor()) {
            case 0 : bufferG.setColor(Color.RED); break;
    		case 1 : bufferG.setColor(Color.GREEN); break;
    		case 2 : bufferG.setColor(Color.BLUE); break;
    		case 3 : bufferG.setColor(Color.CYAN); break;
    		case 4 : bufferG.setColor(Color.MAGENTA); break;
            }
			
			//����
            if(dto.isFill()) {//ä���� ����
            	if(dto.getShape() == Shape.LINE)
            		bufferG.drawLine(x1, y1, x2, y2);
    			else if(dto.getShape() == Shape.CIRCLE)
    				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
    			else if(dto.getShape() == Shape.RECT)
    				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
    			else if(dto.getShape() == Shape.ROUNDRECT)
    				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
    			else if(dto.getShape() == Shape.PEN)
    				bufferG.drawLine(x1, y1, x2, y2);
    				
            }else {//�� ����
            	if(dto.getShape() == Shape.LINE)
            		bufferG.drawLine(x1, y1, x2, y2);
    			else if(dto.getShape() == Shape.CIRCLE)
    				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
    			else if(dto.getShape() == Shape.RECT)
    				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
    			else if(dto.getShape() == Shape.ROUNDRECT)
    				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
    			else if(dto.getShape() == Shape.PEN)
    				bufferG.drawLine(x1, y1, x2, y2);
            }
			
		}//for
		
		//---------------
		//���� �׷����� ����
		//��ǥ
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		
		//��
		switch(msPaint.getCombo().getSelectedIndex()) {
		case 0 : bufferG.setColor(Color.RED); break;
		case 1 : bufferG.setColor(Color.GREEN); break;
		case 2 : bufferG.setColor(Color.BLUE); break;
		case 3 : bufferG.setColor(Color.CYAN); break;
		case 4 : bufferG.setColor(Color.MAGENTA); break;
		}
		
		//����
		if(msPaint.getFill().isSelected()) {//ä���� ����
			if(msPaint.getLine().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected())
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			
		}else {//�� ����
			if(msPaint.getLine().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected())
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected())
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
		}
		
		paint(g);
		
	}//update(Graphics g)
	
	@Override
	public void paint(Graphics g) {//�ݹ�޼ҵ�
		g.drawImage(bufferImage, 0, 0, this);
		
	}//paint(Graphics g)
}















