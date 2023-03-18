package com.diy.api;

import com.diy.generated.model.UserDto;
import com.diy.mapper.UserModelMapper;
import com.diy.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserApiImpl.class, UserModelMapper.class, UserService.class})
@ExtendWith(SpringExtension.class)
class UserApiImplTest {
    @Autowired
    private UserApiImpl userApiImpl;

    /**
     * Method under test: {@link UserApiImpl#createUser(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateUser() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.createUser(new UserDto());
    }

    /**
     * Method under test: {@link UserApiImpl#createHandler(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateHandler() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.createHandler(new UserDto());
    }

    /**
     * Method under test: {@link UserApiImpl#createWorker(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateWorker() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.createWorker(new UserDto());
    }

    /**
     * Method under test: {@link UserApiImpl#deleteUserByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUserByEmail() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.deleteUserByEmail("jane.doe@example.org");
    }

    /**
     * Method under test: {@link UserApiImpl#deleteUsersByStoresId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUsersByStoresId() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.deleteUsersByStoresId(1L);
    }

    /**
     * Method under test: {@link UserApiImpl#getUserByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserByEmail() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.getUserByEmail("jane.doe@example.org");
    }

    /**
     * Method under test: {@link UserApiImpl#getUsersByStoreId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsersByStoreId() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.getUsersByStoreId(1L);
    }

    /**
     * Method under test: {@link UserApiImpl#updateUser(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.NoClassDefFoundError: org/springframework/test/context/TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   java.lang.ClassNotFoundException: org.springframework.test.context.TestContextManager
        //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:1002)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:129)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:527)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:150)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:647)
        //   See https://diff.blue/R026 to resolve this issue.

        userApiImpl.updateUser(new UserDto());
    }
}

