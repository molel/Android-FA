import React, { useState, useMemo } from "react";
import {
  StyleSheet,
  View,
  Text,
  Alert,
  ImageBackground,
  TouchableOpacity,
  TouchableWithoutFeedback,
} from "react-native";

const IMAGE_SOURCE = require("./assets/images.jpg");

import Animated, { Easing, useCode } from "react-native-reanimated";
import Pic from "./Pic";
const {
  Clock,
  Value,
  set,
  cond,
  startClock,
  clockRunning,
  timing,
  debug,
  stopClock,
  block,
  interpolate,
} = Animated;

function runTiming(clock, from, to) {
  const state = {
    finished: new Value(0),
    position: new Value(from),
    time: new Value(0),
    frameTime: new Value(0),
  };

  const config = {
    duration: 200,
    toValue: new Value(to),
    easing: Easing.inOut(Easing.ease),
  };

  return block([
    cond(clockRunning(clock), [], startClock(clock)),
    timing(clock, state, config),
    cond(state.finished, stopClock(clock)),
    state.position,
  ]);
}

const App = () => {
  const [show, setShow] = useState(false);
  const { clock, animatedValue } = useMemo(
    () => ({
      clock: new Clock(),
      animatedValue: new Value(0),
    }),
    []
  );

  useCode(
    () =>
      block([
        show
          ? set(animatedValue, runTiming(clock, 0, 1))
          : set(animatedValue, runTiming(clock, 1, 0)),
      ]),
    [show]
  );

  const opacity = interpolate(animatedValue, {
    inputRange: [0, 1],
    outputRange: [0, 1],
  });
  const translateY = interpolate(animatedValue, {
    inputRange: [0, 0],
    outputRange: [15, 10],
  });

  return (
    <ImageBackground source={IMAGE_SOURCE} style={styles.container}>
      <Pic />
      <TouchableWithoutFeedback onPress={() => setShow(!show)}>
        <View style={styles.buttonContainer}>
          <Animated.View
            style={{
              opacity,
              transform: [{ translateY }],
            }}
          >
            <TouchableOpacity
              style={styles.buttonStyle}
              onPress={() => Alert.alert("Вы выбрали кошку")}
            >
              <Text style={styles.buttonText}>Выбрать кошку</Text>
            </TouchableOpacity>
          </Animated.View>
        </View>
      </TouchableWithoutFeedback>
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1 },
  touchable: { flex: 1 },
  buttonContainer: { flex: 1, alignItems: "center", justifyContent: "center" },
  buttonStyle: {
    paddingHorizontal: 20,
    paddingVertical: 10,
    borderRadius: 20,
    backgroundColor: "black",
  },
  buttonText: {
    color: "white",
    fontWeight: "700",
  },
});

export default App;
