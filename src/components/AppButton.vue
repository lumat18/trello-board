<template>
  <button type="button" class="button" :class="typeClasses">
    <slot />
  </button>
</template>

<script>
export default {
  name: "AppButton",
  props: {
    type: {
      type: String
    }
  },
  computed: {
    typeClasses() {
      switch (this.type) {
        case "danger":
          return "red-button";
        default:
          return "blue-button";
      }
    }
  }
};
</script>

<style scoped>
.red-button {
  color: antiquewhite;
  background: tomato;
}
.blue-button {
  color: aliceblue;
  background: navy;
}
</style>
