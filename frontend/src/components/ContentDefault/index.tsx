import React from 'react';
import { ContentContainer } from './styles';

type ContentProps = {
  children: React.ReactNode;
};

const ContentDefault: React.FC<ContentProps> = ({ children }) => {
  return <ContentContainer>{children}</ContentContainer>;
};

export { ContentDefault };
