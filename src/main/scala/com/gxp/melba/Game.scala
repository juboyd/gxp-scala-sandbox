package com.gxp.melba

import javax.swing.JPanel
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.Image
import javax.swing.ImageIcon
import java.awt.Graphics
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import javax.swing.Timer
import java.awt.Toolkit
import javax.swing.SwingUtilities

class RobotWarsPanel extends JPanel with ActionListener {

  val fighter = new Robot("Dan")

  implicit def spriteToImage(s: Sprite): Image = {
    return s.image
  }

  override def actionPerformed(action: ActionEvent) = {
    Console.println("tic")

    repaint()
  }

  override def paint(g: Graphics) = {
    Console.println("painting")

    super.paint(g)
    getGraphics().drawImage(fighter, 25, 25, this)
  }
}

class RobotWarsFrame(panel:RobotWarsPanel) extends JFrame {

  add(panel)
  setTitle("Melba")
  setDefaultCloseOperation(EXIT_ON_CLOSE)
  setSize(400, 400)
  setLocationRelativeTo(null)
  setVisible(true)
  setResizable(false)
}

class Sprite(name: String) {

  val image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("/" + name))
}

class Robot(name: String) extends Sprite("fighter-left.gif") {}

object Game extends App {

  val stage = new RobotWarsPanel
  val frame = new RobotWarsFrame(stage)

//  new Timer(60, stage).start
}