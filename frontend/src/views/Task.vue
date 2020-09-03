<template>
  <div class="task-view">
    <input
      type="text"
      :value="task.name"
      @change="updateTaskProperty($event, 'name')"
    />
    <textarea
      class="task-description"
      :value="task.description"
      @change="updateTaskProperty($event, 'description')"
    />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "Task",
  computed: {
    ...mapGetters(["getTask"]),
    task() {
      return this.getTask(this.$route.params.id);
    }
  },
  methods: {
    updateTaskProperty(event, key) {
      this.$store.commit("UPDATE_TASK", {
        task: this.task,
        key,
        value: event.target.value
      });
    }
  }
};
</script>

<style scoped>
.task-view {
  width: 600px;
  height: 300px;
  background: white;
  border-radius: 8px;
  padding: 8px;
}
.task-description {
  border: none;
}
</style>
