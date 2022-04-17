import { StatusBar } from "expo-status-bar";
import { StyleSheet, View, Button, Alert } from "react-native";

export default function App() {
  return (
    <View style={styles.container}>
      <Button
        title="Нажми меня"
        onPress={() => {
          Alert.alert("Внимание", "Среда разработки была успешно установлена");
        }}
      ></Button>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
