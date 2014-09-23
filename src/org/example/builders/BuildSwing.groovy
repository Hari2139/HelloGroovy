package org.example.builders

import groovy.swing.SwingBuilder

bldr = new SwingBuilder()

frame = bldr.frame(
	title: 'Swing',
	size: [50, 100],
	layout: new java.awt.FlowLayout(),
	defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE) 
	{
		lbl = label (text: 'test')
		btn = button (text: 'Click me', actionPerformed: {
			btn.text = 'Clicked'
			lbl.text = "Groovy!"
		})
	}
	
frame.setVisible(true)











