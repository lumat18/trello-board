<template>
  <AppDrop @drop="moveTaskOrColumn">
    <AppDrag
      :transfer-data="{
        type: 'task',
        fromColumnIndex: columnIndex,
        fromTaskIndex: taskIndex
      }"
      ><div class="task" @click="openModal(task)">
        <span :class="'task-title' + taskIndex">{{ task.name }}</span>
        <p v-if="task.description">{{ task.description }}</p>
      </div>
    </AppDrag>
  </AppDrop>
</template>
<script>
import MovingTasksAndColumnsMixin from "../mixins/MovingTasksAndColumnsMixin";
import AppDrag from "./AppDrag";
import AppDrop from "./AppDrop";

export default {
  name: "ColumnTask",
  mixins: [MovingTasksAndColumnsMixin],
  components: { AppDrag, AppDrop },
  props: {
    task: {
      type: Object,
      required: true
    },
    taskIndex: {
      type: Number,
      required: true
    }
  },
  methods: {
    openModal(task) {
      this.$router.push({ name: "task", params: { id: task.id } });
    }
  }
};
</script>

<style scoped>
.task {
  display: block;
  cursor: pointer;
  background-color: lightgray;
  border: 1px solid black;
  border-radius: 8px;
  margin: 4px;
  padding: 4px;
}
</style>
