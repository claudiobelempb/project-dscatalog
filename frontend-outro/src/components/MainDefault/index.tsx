import { ContainerDefault } from '../ContainerDefault';
import { ContentDefault } from '../ContentDefault';
import { MainContainer } from './styles';

type MainProps = {
  children: React.ReactNode;
};
const MainDefault: React.FC<MainProps> = ({ children }) => {
  return (
    <MainContainer>
      <ContainerDefault>
        <ContentDefault>{children}</ContentDefault>
      </ContainerDefault>
    </MainContainer>
  );
};

export { MainDefault };
