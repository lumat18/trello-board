<template>
  <div class="modal">
    <div class="message">{{ message }}</div>
  </div>
</template>

<script>
export default {
  name: "Error",
  props: {
    message: {
      type: String,
      required: true
    }
  }
};
</script>

<style scoped>
.modal {
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
  background: rgba(76, 175, 80, 0.8);
  top: 0;
  left: 0;
  height: 100vh;
  width: 100vw;
}
.message {
  width: 600px;
  height: 300px;
  background: white;
  border-radius: 8px;
  padding: 8px;
}
</style>
