package io.github.anvil008.keyboard.motion;

/**
 * Created by Anvil on 5-Jan-16.
 */

import com.leapmotion.leap.*;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture.Type;

import java.awt.*;
import java.awt.event.InputEvent;

public class GestureControl extends Listener {
    public Robot robot;

    public void onInit(Controller controller) {
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.config().setFloat("Gesture.KeyTap.MinDownVelocity", 40.0f);
        controller.config().setFloat("Gesture.KeyTap.HistorySeconds", .2f);
        controller.config().setFloat("Gesture.KeyTap.MinDistance", 1.0f);
        controller.config().save();
        System.out.println("Motion Detection Activated");
    }

    //on leap device connected
    public void onConnect(Controller controller) {
    }

    //getting gestures performed on frame
    public void onFrame(Controller controller) {
        Frame frame = controller.frame();        //giving device control to frame
        InteractionBox box = frame.interactionBox();
        try {
            robot = new Robot();
        } catch (Exception e) {
        }

        //for moving mouse cursor
        for (Hand hand : frame.hands()) {
            if (hand.isRight()) {
                for (Finger thumb : hand.fingers()) {
                    for (Finger index : hand.fingers()) {
                        for (Finger middle : hand.fingers()) {
                            for (Finger pinky : hand.fingers()) {
                                for (Finger ring : hand.fingers()) {


                                    boolean motionEnable = !thumb.isExtended() && index.isExtended() && !middle.isExtended() && !pinky.isExtended() && !ring.isExtended();

                                    if (thumb.type() == Finger.Type.TYPE_THUMB &&
                                            index.type() == Finger.Type.TYPE_INDEX && middle.type() == Finger.Type.TYPE_MIDDLE
                                            && pinky.type() == Finger.Type.TYPE_PINKY && ring.type() == Finger.Type.TYPE_RING && motionEnable) {

                                        Vector handpos = hand.stabilizedPalmPosition();
                                        Vector boxHandpos = box.normalizePoint(handpos);
                                        Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                                        robot.mouseMove((int) (screen.width * boxHandpos.getX()), (int) (screen.height - boxHandpos.getY() * screen.height));

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        //for scrolling mouse
        for (Gesture gesture : frame.gestures()) {
            for (Hand hand : frame.hands()) {
                if (hand.isLeft()) {
                    for (Finger thumb : hand.fingers()) {
                        for (Finger index : hand.fingers()) {
                            for (Finger middle : hand.fingers()) {
                                for (Finger pinky : hand.fingers()) {
                                    for (Finger ring : hand.fingers()) {

                                        Boolean condition1=!thumb.isExtended() && index.isExtended() && middle.isExtended() && !pinky.isExtended() && !ring.isExtended();

                                        if (thumb.type() == Finger.Type.TYPE_THUMB && index.type() == Finger.Type.TYPE_INDEX && middle.type() == Finger.Type.TYPE_MIDDLE
                                              && pinky.type() == Finger.Type.TYPE_PINKY && ring.type() == Finger.Type.TYPE_RING
                                              && gesture.type() == Type.TYPE_CIRCLE && condition1 ) {

                                                    CircleGesture circle = new CircleGesture(gesture);
                                                    if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 3) {
                                                        robot.mouseWheel(1);
                                                        try {
                                                            Thread.sleep(50);
                                                        } catch (Exception e) {
                                                        }

                                                    } else {
                                                        robot.mouseWheel(-1);
                                                        try {
                                                            Thread.sleep(50);
                                                        } catch (Exception e) {
                                                        }
                                                    }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        //to perform left click and right click
        for (Gesture gesture : frame.gestures()) {
            for (Hand hand : frame.hands()) {
                if (hand.isLeft()) {
                    for (Finger thumb : hand.fingers()) {
                        for (Finger index : hand.fingers()) {
                            for (Finger middle : hand.fingers()) {
                                for (Finger pinky : hand.fingers()) {
                                    for (Finger ring : hand.fingers()) {
                                        if (thumb.type() == Finger.Type.TYPE_THUMB && index.type() == Finger.Type.TYPE_INDEX
                                                && middle.type() == Finger.Type.TYPE_MIDDLE && pinky.type() == Finger.Type.TYPE_PINKY
                                                && ring.type() == Finger.Type.TYPE_RING) {

                                            Boolean contion1 = !thumb.isExtended() && index.isExtended() && !middle.isExtended() && !pinky.isExtended() && !ring.isExtended(), condition2 = !thumb.isExtended() && index.isExtended() && middle.isExtended() && !pinky.isExtended() && !ring.isExtended();
                                            if (contion1 && gesture.type() == Type.TYPE_SCREEN_TAP) {

                                                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                                try {
                                                    Thread.sleep(50);
                                                } catch (Exception e) {
                                                }
                                                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                                            } else if (condition2 && gesture.type() == Type.TYPE_SCREEN_TAP) {

                                                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                                                try {
                                                    Thread.sleep(50);
                                                } catch (Exception e) {
                                                }
                                                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

                                            }


                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }



    }
}

