// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

public interface MethodContextOrBuilder extends
    // @@protoc_insertion_point(interface_extends:data.MethodContext)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.data.ContextValues context_values = 1;</code>
   * @return Whether the contextValues field is set.
   */
  boolean hasContextValues();
  /**
   * <code>.data.ContextValues context_values = 1;</code>
   * @return The contextValues.
   */
  eu.tsystems.mms.tic.testframework.report.model.ContextValues getContextValues();
  /**
   * <code>.data.ContextValues context_values = 1;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ContextValuesOrBuilder getContextValuesOrBuilder();

  /**
   * <code>.data.MethodType method_type = 7;</code>
   * @return The enum numeric value on the wire for methodType.
   */
  int getMethodTypeValue();
  /**
   * <code>.data.MethodType method_type = 7;</code>
   * @return The methodType.
   */
  eu.tsystems.mms.tic.testframework.report.model.MethodType getMethodType();

  /**
   * <pre>
   *repeated string parameters = 8 [deprecated = true];
   *    repeated string method_tags = 9 [deprecated = true];
   * </pre>
   *
   * <code>int32 retry_number = 10;</code>
   * @return The retryNumber.
   */
  int getRetryNumber();

  /**
   * <code>int32 method_run_index = 11;</code>
   * @return The methodRunIndex.
   */
  int getMethodRunIndex();

  /**
   * <code>string thread_name = 12;</code>
   * @return The threadName.
   */
  java.lang.String getThreadName();
  /**
   * <code>string thread_name = 12;</code>
   * @return The bytes for threadName.
   */
  com.google.protobuf.ByteString
      getThreadNameBytes();

  /**
   * <pre>
   *    TestStep failed_step = 13;
   * </pre>
   *
   * <code>.data.FailureCorridorValue failure_corridor_value = 14;</code>
   * @return The enum numeric value on the wire for failureCorridorValue.
   */
  int getFailureCorridorValueValue();
  /**
   * <pre>
   *    TestStep failed_step = 13;
   * </pre>
   *
   * <code>.data.FailureCorridorValue failure_corridor_value = 14;</code>
   * @return The failureCorridorValue.
   */
  eu.tsystems.mms.tic.testframework.report.model.FailureCorridorValue getFailureCorridorValue();

  /**
   * <code>string class_context_id = 15;</code>
   * @return The classContextId.
   */
  java.lang.String getClassContextId();
  /**
   * <code>string class_context_id = 15;</code>
   * @return The bytes for classContextId.
   */
  com.google.protobuf.ByteString
      getClassContextIdBytes();

  /**
   * <code>string execution_context_id = 16 [deprecated = true];</code>
   * @return The executionContextId.
   */
  @java.lang.Deprecated java.lang.String getExecutionContextId();
  /**
   * <code>string execution_context_id = 16 [deprecated = true];</code>
   * @return The bytes for executionContextId.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getExecutionContextIdBytes();

  /**
   * <pre>
   *    repeated ErrorContext non_functional_infos = 17 [deprecated = true];
   *    repeated ErrorContext collected_assertions = 18 [deprecated = true];
   * </pre>
   *
   * <code>repeated string infos = 19 [deprecated = true];</code>
   * @return A list containing the infos.
   */
  @java.lang.Deprecated java.util.List<java.lang.String>
      getInfosList();
  /**
   * <pre>
   *    repeated ErrorContext non_functional_infos = 17 [deprecated = true];
   *    repeated ErrorContext collected_assertions = 18 [deprecated = true];
   * </pre>
   *
   * <code>repeated string infos = 19 [deprecated = true];</code>
   * @return The count of infos.
   */
  @java.lang.Deprecated int getInfosCount();
  /**
   * <pre>
   *    repeated ErrorContext non_functional_infos = 17 [deprecated = true];
   *    repeated ErrorContext collected_assertions = 18 [deprecated = true];
   * </pre>
   *
   * <code>repeated string infos = 19 [deprecated = true];</code>
   * @param index The index of the element to return.
   * @return The infos at the given index.
   */
  @java.lang.Deprecated java.lang.String getInfos(int index);
  /**
   * <pre>
   *    repeated ErrorContext non_functional_infos = 17 [deprecated = true];
   *    repeated ErrorContext collected_assertions = 18 [deprecated = true];
   * </pre>
   *
   * <code>repeated string infos = 19 [deprecated = true];</code>
   * @param index The index of the value to return.
   * @return The bytes of the infos at the given index.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getInfosBytes(int index);

  /**
   * <code>string priority_message = 21 [deprecated = true];</code>
   * @return The priorityMessage.
   */
  @java.lang.Deprecated java.lang.String getPriorityMessage();
  /**
   * <code>string priority_message = 21 [deprecated = true];</code>
   * @return The bytes for priorityMessage.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getPriorityMessageBytes();

  /**
   * <code>repeated string related_method_context_ids = 23;</code>
   * @return A list containing the relatedMethodContextIds.
   */
  java.util.List<java.lang.String>
      getRelatedMethodContextIdsList();
  /**
   * <code>repeated string related_method_context_ids = 23;</code>
   * @return The count of relatedMethodContextIds.
   */
  int getRelatedMethodContextIdsCount();
  /**
   * <code>repeated string related_method_context_ids = 23;</code>
   * @param index The index of the element to return.
   * @return The relatedMethodContextIds at the given index.
   */
  java.lang.String getRelatedMethodContextIds(int index);
  /**
   * <code>repeated string related_method_context_ids = 23;</code>
   * @param index The index of the value to return.
   * @return The bytes of the relatedMethodContextIds at the given index.
   */
  com.google.protobuf.ByteString
      getRelatedMethodContextIdsBytes(int index);

  /**
   * <code>repeated string depends_on_method_context_ids = 24;</code>
   * @return A list containing the dependsOnMethodContextIds.
   */
  java.util.List<java.lang.String>
      getDependsOnMethodContextIdsList();
  /**
   * <code>repeated string depends_on_method_context_ids = 24;</code>
   * @return The count of dependsOnMethodContextIds.
   */
  int getDependsOnMethodContextIdsCount();
  /**
   * <code>repeated string depends_on_method_context_ids = 24;</code>
   * @param index The index of the element to return.
   * @return The dependsOnMethodContextIds at the given index.
   */
  java.lang.String getDependsOnMethodContextIds(int index);
  /**
   * <code>repeated string depends_on_method_context_ids = 24;</code>
   * @param index The index of the value to return.
   * @return The bytes of the dependsOnMethodContextIds at the given index.
   */
  com.google.protobuf.ByteString
      getDependsOnMethodContextIdsBytes(int index);

  /**
   * <code>.data.ErrorContext error_context = 25 [deprecated = true];</code>
   * @return Whether the errorContext field is set.
   */
  @java.lang.Deprecated boolean hasErrorContext();
  /**
   * <code>.data.ErrorContext error_context = 25 [deprecated = true];</code>
   * @return The errorContext.
   */
  @java.lang.Deprecated eu.tsystems.mms.tic.testframework.report.model.ErrorContext getErrorContext();
  /**
   * <code>.data.ErrorContext error_context = 25 [deprecated = true];</code>
   */
  @java.lang.Deprecated eu.tsystems.mms.tic.testframework.report.model.ErrorContextOrBuilder getErrorContextOrBuilder();

  /**
   * <code>repeated .data.TestStep test_steps = 26;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.TestStep> 
      getTestStepsList();
  /**
   * <code>repeated .data.TestStep test_steps = 26;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.TestStep getTestSteps(int index);
  /**
   * <code>repeated .data.TestStep test_steps = 26;</code>
   */
  int getTestStepsCount();
  /**
   * <code>repeated .data.TestStep test_steps = 26;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.TestStepOrBuilder> 
      getTestStepsOrBuilderList();
  /**
   * <code>repeated .data.TestStep test_steps = 26;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.TestStepOrBuilder getTestStepsOrBuilder(
      int index);

  /**
   * <code>string test_context_id = 27 [deprecated = true];</code>
   * @return The testContextId.
   */
  @java.lang.Deprecated java.lang.String getTestContextId();
  /**
   * <code>string test_context_id = 27 [deprecated = true];</code>
   * @return The bytes for testContextId.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getTestContextIdBytes();

  /**
   * <code>string suite_context_id = 28 [deprecated = true];</code>
   * @return The suiteContextId.
   */
  @java.lang.Deprecated java.lang.String getSuiteContextId();
  /**
   * <code>string suite_context_id = 28 [deprecated = true];</code>
   * @return The bytes for suiteContextId.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getSuiteContextIdBytes();

  /**
   * <code>repeated string session_context_ids = 29;</code>
   * @return A list containing the sessionContextIds.
   */
  java.util.List<java.lang.String>
      getSessionContextIdsList();
  /**
   * <code>repeated string session_context_ids = 29;</code>
   * @return The count of sessionContextIds.
   */
  int getSessionContextIdsCount();
  /**
   * <code>repeated string session_context_ids = 29;</code>
   * @param index The index of the element to return.
   * @return The sessionContextIds at the given index.
   */
  java.lang.String getSessionContextIds(int index);
  /**
   * <code>repeated string session_context_ids = 29;</code>
   * @param index The index of the value to return.
   * @return The bytes of the sessionContextIds at the given index.
   */
  com.google.protobuf.ByteString
      getSessionContextIdsBytes(int index);

  /**
   * <pre>
   *    repeated string video_ids = 30  [deprecated = true];
   *    repeated string screenshot_ids = 31 [deprecated = true];
   *    string custom_context_json = 32 [deprecated = true];
   * </pre>
   *
   * <code>int32 failed_step_index = 33;</code>
   * @return The failedStepIndex.
   */
  int getFailedStepIndex();

  /**
   * <code>.data.ResultStatusType result_status = 34;</code>
   * @return The enum numeric value on the wire for resultStatus.
   */
  int getResultStatusValue();
  /**
   * <code>.data.ResultStatusType result_status = 34;</code>
   * @return The resultStatus.
   */
  eu.tsystems.mms.tic.testframework.report.model.ResultStatusType getResultStatus();

  /**
   * <code>map&lt;string, string&gt; parameters = 35;</code>
   */
  int getParametersCount();
  /**
   * <code>map&lt;string, string&gt; parameters = 35;</code>
   */
  boolean containsParameters(
      java.lang.String key);
  /**
   * Use {@link #getParametersMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getParameters();
  /**
   * <code>map&lt;string, string&gt; parameters = 35;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getParametersMap();
  /**
   * <code>map&lt;string, string&gt; parameters = 35;</code>
   */

  java.lang.String getParametersOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; parameters = 35;</code>
   */

  java.lang.String getParametersOrThrow(
      java.lang.String key);

  /**
   * <code>map&lt;string, string&gt; custom_contexts = 36;</code>
   */
  int getCustomContextsCount();
  /**
   * <code>map&lt;string, string&gt; custom_contexts = 36;</code>
   */
  boolean containsCustomContexts(
      java.lang.String key);
  /**
   * Use {@link #getCustomContextsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getCustomContexts();
  /**
   * <code>map&lt;string, string&gt; custom_contexts = 36;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getCustomContextsMap();
  /**
   * <code>map&lt;string, string&gt; custom_contexts = 36;</code>
   */

  java.lang.String getCustomContextsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; custom_contexts = 36;</code>
   */

  java.lang.String getCustomContextsOrThrow(
      java.lang.String key);

  /**
   * <code>map&lt;string, string&gt; annotations = 37;</code>
   */
  int getAnnotationsCount();
  /**
   * <code>map&lt;string, string&gt; annotations = 37;</code>
   */
  boolean containsAnnotations(
      java.lang.String key);
  /**
   * Use {@link #getAnnotationsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getAnnotations();
  /**
   * <code>map&lt;string, string&gt; annotations = 37;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getAnnotationsMap();
  /**
   * <code>map&lt;string, string&gt; annotations = 37;</code>
   */

  java.lang.String getAnnotationsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; annotations = 37;</code>
   */

  java.lang.String getAnnotationsOrThrow(
      java.lang.String key);

  /**
   * <pre>
   * A custom generated test name (e.a. cucumber scenario)
   * </pre>
   *
   * <code>string test_name = 38;</code>
   * @return The testName.
   */
  java.lang.String getTestName();
  /**
   * <pre>
   * A custom generated test name (e.a. cucumber scenario)
   * </pre>
   *
   * <code>string test_name = 38;</code>
   * @return The bytes for testName.
   */
  com.google.protobuf.ByteString
      getTestNameBytes();
}
