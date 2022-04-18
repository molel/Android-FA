import { View, StyleSheet, StatusBar } from "react-native";
import GIFList from "../components/GIFList";
import Header from "../components/Header";
import colors from "../theme/colors";

function MainApp() {
  return (
    <View style={styles.appContainer}>
      <StatusBar backgroundColor={colors.primaryDark} />
      <Header />
      <GIFList />
    </View>
  );
}

const styles = StyleSheet.create({
  appContainer: { flex: 1, backgroundColor: colors.background },
});

export default MainApp;
